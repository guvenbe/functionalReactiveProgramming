package com.basicsstrong.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterDemo {
    public static void main(String[] args) {
        Stream.of(34,678,89,4,52,31,325,6)
                .filter(e->e%2==0).collect(Collectors.toList()).forEach(System.out::println);
    }
}
