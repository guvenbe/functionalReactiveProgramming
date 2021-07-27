package com.basicsstrong.collectors.observableandobserverRxjava;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

class Employee {

    private Integer id;
    private String name;
    double salary,rating;

    public Employee(Integer id, String name, double salary, double rating) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.rating = rating;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", rating=" + rating + "]";
    }
}

public class Operators {
    public static void main(String[] args) {
        Observable.just(60,57,89,90,23,100,98)
                .filter(e->e>75)
                .sorted()
                .subscribe(e-> System.out.println("Grade a with " +e));


        Observable<Employee> obs = Observable.just(
                new Employee(101,"Alexa",60000,4.0),
                new Employee(123,"Dhwanit",94000,4.7),
                new Employee(236,"Mike",65000,4.0),
                new Employee(155,"Ella",85000,4.4),
                new Employee(443,"George",50000,3.6),
                new Employee(127,"Shreeja",85000,4.5),
                new Employee(509,"Daniel",60000,4.0),
                new Employee(344,"Lucy",94000,4.7),
                new Employee(509,"Harry",75000,4.3),
                new Employee(344,"Emma",55000,3.7)
        );

        obs
                .filter(e->e.getRating()>4.0)
                .sorted((e1,e2)->Double.compare(e2.getRating(),e1.getRating()))
                .map(e-> e.getName())
                .take(4)
                .toList()
                .subscribe(System.out::println);

        List<Integer> expenses = List.of(200,500,300,340,129,234,999,1030,3400,890,996,789);

        Observable.fromIterable(expenses)
                .reduce((a,b)->a+b)
                .subscribe(System.out::println);

        Observable.fromIterable(expenses)
                .scan((a,b)->a+b) //result at each step..Running total
                .subscribe(System.out::println);

    }
}
