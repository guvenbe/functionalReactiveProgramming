package com.basicsstrong.collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CasscadingCollectors {
    public static void main(String[] args) {
        Path path = Paths.get("/home/vagrant/IdeaProjects/functionalReactive/src/main/java/com/basicsstrong/collectors/EmployeeData.txt");

        try (Stream<String> lines = Files.lines(path);) {
            Spliterator<String> wordSpliterators = lines.flatMap(line -> Arrays.stream(line.split(","))).spliterator();
            EmployeeSpliterator employeeSpliterator = new EmployeeSpliterator(wordSpliterators);
            List<Employee> employeeList = StreamSupport.stream(employeeSpliterator, false)
                    .collect(Collectors.toList());

            Map<String, Long> countByDesignation = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(e -> e.getDesignation(), Collectors.counting()));

            System.out.println(countByDesignation);

            Map<String, Double> fundDistribution = employeeList.stream()
                    .collect(Collectors.groupingBy(e -> e.getDesignation(),
                            Collectors.summingDouble(e -> e.getSalary())
                            )
                    );
            System.out.println(fundDistribution);

            Map<String, Optional<Employee>> maxSalaryEmployees = employeeList.stream()
                    .collect(Collectors.groupingBy(e -> e.getDesignation(),
                            Collectors.maxBy(Comparator.comparing((e -> e.getSalary())))
                            )
                    );
            System.out.println(maxSalaryEmployees);

            Map<String, Optional<Double>> maxSalaries =
                    employeeList.stream()
                            .collect(
                                    Collectors.groupingBy(
                                            e -> e.getDesignation(),
                                            Collectors.mapping(
                                                    e -> e.getSalary(),
                                                    Collectors.maxBy(Comparator.comparing(e -> e.doubleValue()))
                                            )
                                    )
                            );

            System.out.println(maxSalaries);
 //        Not working
//            Map<String, Optional<Double>> maxSalaries =
//                    employeeList.stream()
//                            .collect(
//                                    Collectors.groupingBy(
//                                            e -> e.getDesignation(),
//                                            Collectors.mapping(
//                                                    e -> e.getSalary(),
//                                                    Collectors.maxBy(Comparator.comparing(Function.identity()))
//                                            )
//                                    )
//                            );




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
