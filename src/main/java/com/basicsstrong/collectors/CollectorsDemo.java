package com.basicsstrong.collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private char gender;
    private Date dob;
    private String city;
    private String designation;
    private Date joiningDate;
    private double salary;

    public Employee(int id, String name, char gender, Date dob, String city, String designation,
                    Date joiningDate, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.city = city;
        this.designation = designation;
        this.joiningDate = joiningDate;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", city=" + city
                + ", designation=" + designation + ", joiningDate=" + joiningDate + ", salary=" + salary + "]";
    }

    @Override
    public int compareTo(Employee o) {

        if (this.id < o.id)
            return -1;
        else if (this.id > o.id)
            return 1;
        else
            return 0;
    }

}

class EmployeeSpliterator implements Spliterator<Employee> {

    private Spliterator<String> wordSpliterator;
    private int id;
    private String name;
    private char gender;
    private Date dob;
    private String city;
    private String designation;
    private Date joiningDate;
    private double salary;


    public EmployeeSpliterator(Spliterator<String> wordSpliterator) {
        this.wordSpliterator = wordSpliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Employee> action) {

        if (this.wordSpliterator.tryAdvance(word -> this.id = Integer.valueOf(word))
                && this.wordSpliterator.tryAdvance(word -> this.name = word)
                && this.wordSpliterator.tryAdvance(word -> this.gender = word.charAt(0))
                && this.wordSpliterator.tryAdvance(word -> this.dob = Date.valueOf(word))
                && this.wordSpliterator.tryAdvance(word -> this.city = word)
                && this.wordSpliterator.tryAdvance(word -> this.designation = word)
                && this.wordSpliterator.tryAdvance(word -> this.joiningDate = Date.valueOf(word))
                && this.wordSpliterator.tryAdvance(word -> this.salary = Double.valueOf(word))
        ) {
            action.accept(new Employee(this.id,
                    this.name,
                    this.gender,
                    this.dob,
                    this.city,
                    this.designation,
                    this.joiningDate,
                    this.salary
            ));
            return true;
        }

        return false;
    }

    @Override
    public Spliterator<Employee> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return wordSpliterator.estimateSize() / 8;
    }

    @Override
    public int characteristics() {
        return wordSpliterator.characteristics();
    }

}

public class CollectorsDemo {
    public static void main(String[] args) {
        Path path = Paths.get("/home/vagrant/IdeaProjects/functionalReactive/src/main/java/com/basicsstrong/collectors/EmployeeData.txt");

        try (Stream<String> lines = Files.lines(path);) {
            Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
            Spliterator<String> wordSpliterator = words.spliterator();
            Spliterator<Employee> emplyeeSpliterator = new EmployeeSpliterator(wordSpliterator);
            Stream<Employee> employees = StreamSupport.stream(emplyeeSpliterator, false);
            List<Employee> employeeList = employees.collect(Collectors.toList());
            //employees.forEach(System.out::println);

            List<String> employeeNames = employeeList.stream()
                    .map(name -> name.getName())
                    .collect(Collectors.toList());
            System.out.println("----------x-------------LIST------------------x---------------");
            employeeNames.forEach(System.out::println);

            Set<String> designationsSet = employeeList.stream()
                    .map(e -> e.getDesignation())
                    .collect(Collectors.toSet());//Avoid repeating entries
            System.out.println("----------x-------------SET------------------x---------------");
            designationsSet.forEach(System.out::println);

//            employeeList.stream()
//                    .collect(Collectors.toCollection(()-> new TreeSet()));

            TreeSet<Employee> treeSetEmployeeSorted = employeeList.stream()
                    .collect(Collectors.toCollection(TreeSet::new));
            System.out.println("----------x-------------COLLECTION(TreeSet)------------------x---------------");
            treeSetEmployeeSorted.forEach(System.out::println);

            Map<Integer, String> getNameById = employeeList.stream()
                    .collect(
                            Collectors.toMap(e -> e.getId(), e -> e.getName()));

           System.out.println(getNameById);

           //Partition by male and female employees

            Map<Boolean, List<Employee>> partitioneData = employeeList.stream()
                    .collect(
                            Collectors.partitioningBy(e -> e.getGender() == 'M')
            );
            System.out.println(partitioneData);

            //Get all males in collection

            List<Employee> maleEmployees = partitioneData.get(true);
            List<Employee> femaleEmployees = partitioneData.get(false);

            //partitioned by designation
            Map<String, List<Employee>> getByDesignation = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(e -> e.getDesignation()));

            System.out.println(getByDesignation);

            //Return list as string
            String employeeNames1 = employeeList.stream()
                    .map(e -> e.getName())
                    .collect(Collectors.joining(", "));
            System.out.println(employeeNames1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
