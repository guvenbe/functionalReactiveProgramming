package com.basicsstrong.collectors;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class CustomCollectorSorted {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 6, 8, 9, 0, 1, 52, 5, 61, 8, 9, 96, 0, 18, 23);


        Collector<Integer, List<Integer>, List<Integer>> toList = Collector.of(ArrayList::new, //supplier
                (list, e) -> list.add(e),//BiConsumer
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                },//BiFunction
                Collector.Characteristics.IDENTITY_FINISH
        );

        Stream<Integer> evens = numbers.stream()
                .filter(e -> e % 2 == 0);

        evens.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");
        Collector<Integer, List<Integer>, List<Integer>> toSortedList = Collector.of(ArrayList::new, //supplier
                (list, e) -> list.add(e),//BiConsumer
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                },//BiFunction
                (list) -> {
                    Collections.sort(list);
                    return list;
                },Collector.Characteristics.UNORDERED);

        List<Integer> sortedList = numbers.stream().collect(toSortedList);

        sortedList.forEach(System.out::println);

    }
}
