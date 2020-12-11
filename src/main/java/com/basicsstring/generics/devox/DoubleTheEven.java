package com.basicsstring.generics.devox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DoubleTheEven {

    public static void main(String[] args) {
        List<Integer> list =List.of(1,2,4,7,8,12,45,46,78,77);

        List<Integer> douledList = list.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .collect(Collectors.toList());
        System.out.println(douledList);
    }

}
