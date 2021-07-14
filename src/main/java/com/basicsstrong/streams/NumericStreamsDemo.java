package com.basicsstrong.streams;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumericStreamsDemo {
    public static void main(String[] args) {
        List<Book2> list = new ArrayList<>();
        list.add(new Book2("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
        list.add(new Book2("The Notebook", "Nicholas Sparks", "Romance", 4.10));
        list.add(new Book2("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
        list.add(new Book2("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));

        OptionalDouble average = list.stream()
                .mapToDouble(book2 -> book2.getRating())
                .average();
        System.out.println(average.getAsDouble());

        //creates primitive streams
        IntStream intStream = IntStream.of(1, 3, 5, 8);
        DoubleStream doubleStream = DoubleStream.of(1, 3, 5, 8);
        LongStream longStream = LongStream.of(1L, 3L, 5L, 8L);

        //Opposite of un boxing
        Stream<Integer> boxed = intStream.boxed();
        //this returms primitive

        doubleStream.mapToObj(val->val);

        //Methods

        int sum = IntStream.of(1, 2, 3).sum();
        System.out.println("sum=" + sum);

        OptionalInt max = IntStream.of(1, 2, 3).max();
        System.out.println(max.getAsInt());

        OptionalInt min = IntStream.of(1, 2, 3).min();
        System.out.println(min.getAsInt());

        OptionalDouble average1 = IntStream.of(1, 2, 3).average();
        System.out.println(average1.getAsDouble());

        IntSummaryStatistics intSummaryStatistics = IntStream.of(1, 2, 3).summaryStatistics();
        System.out.println(intSummaryStatistics);

    }
}
