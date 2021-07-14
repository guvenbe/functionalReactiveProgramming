package com.basicsstrong.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoundedStreams {
    public static void main(String[] args) {
        //1. stream() on a Collection
        List<Integer> list = List.of(1,4,7,9,4);
        Stream<Integer> streamIntegers = list.stream();

        //How can we stream a Map
        Map<Integer,String> map =
                Map.of(1, "One", 2, "Two", 3, "Three", 4, "Four");
        Stream<Map.Entry<Integer, String>> entries = map.entrySet().stream();

        Stream<String> values = map.values().stream();
        Stream<Integer> keys = map.keySet().stream();

        //2. of() Stream class
        Stream<String> of = Stream.of("Hey! ", "Happy", "Thanksgiving");

        //3 Stream of arrays class
        Integer[] integersArray= {3,5,7,89,9};
        Arrays.stream(integersArray);

        int intArr[] = {3,5,7,89,9};
        IntStream stream = Arrays.stream(intArr);

        //4. builder() of stream class
        Stream.Builder<Integer> builder = Stream.builder();
        builder.add(1);

        //code

        //condition
        builder.add(4);
        Stream<Integer> build = builder.build();
    }
}

