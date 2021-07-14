package com.basicsstrong.streams;

import java.util.stream.Stream;

public class ReduceDemo {
    public static void main(String[] args) {
        Integer reduce = Stream.of(1, 2, 34, 56, 76, 87, 89, 90).reduce(0, (a, b) -> (a + b));
        System.out.println(reduce);
    }
}
