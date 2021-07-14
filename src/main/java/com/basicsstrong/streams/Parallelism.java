package com.basicsstrong.streams;

import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String name, int salary) {

        this.name = name;
        this.salary = salary;
    }

}

public class Parallelism {
    public static void main(String[] args) {

        long startTime;
        long endTime;

        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(new Employee("John", 20000));
            list.add(new Employee("Rohn", 3000));
            list.add(new Employee("Tom", 15000));
            list.add(new Employee("Bheem", 8000));
            list.add(new Employee("Shiva", 200));
            list.add(new Employee("Krishna", 50000));
        }
        startTime = System.currentTimeMillis();
        System.out.println("Performing sequentially: " +
                list.stream()
                .filter(e->e.getSalary()>1000)
                .count());

        endTime = System.currentTimeMillis();
        System.out.println("Time take with Sequential Stream: " + (endTime-startTime));

        startTime = System.currentTimeMillis();
        System.out.println("Performing parallel: " +
                list.parallelStream()
                        .filter(e->e.getSalary()>1000)
                        .count());
        endTime = System.currentTimeMillis();
        System.out.println("Time take with Sequential Stream " + (endTime-startTime));
    }
}
