package com.basicsstrong.listandmapfunctionalstyle;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetFunctionalOperations {
    public static void main(String[] args) {
        Set<Integer> set = Set.of(3,56, 7, 82,39);

        set.forEach(System.out::println);
        System.out.println("-------------------------------");

        set.stream().filter(i->i%2==0).forEach(System.out::println);
        System.out.println("-------------------------------");
        //Sorting...There is a sorted set for that

        System.out.println("-------------------------------");
        set.stream()
                .sorted()
                .forEach(System.out::println);

        TreeSet<Integer> sortedSet = set.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println("-------------------------------");
        sortedSet.forEach(System.out::println);

        //map
        System.out.println("-------------------------------");
        set.stream()
                .map(e->e.doubleValue()).collect(Collectors.toSet());

        //another way
        //map
        System.out.println("-------------------------------");
        Set<Double> hashSet = set.stream()
                .map(e -> Double.valueOf(e)).collect(Collectors.toSet());
        hashSet.forEach(System.out::println);

        //Reduce
        Optional<Integer> sumOptional = set.stream().reduce((a, b) -> a + b);
        System.out.println(sumOptional.get());

        //Or

        int sum = set.stream().mapToInt(number -> number).sum();
        System.out.println(sum);
    }

}
