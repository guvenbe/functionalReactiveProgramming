package com.basicsstrong.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAreLazyDemo {
    public static void main(String[] args) {
        List<Book2> books = new ArrayList<>();
        books.add(new Book2("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
        books.add(new Book2("The Notebook", "Nicholas Sparks", "Romance", 4.10));
        books.add(new Book2("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
        books.add(new Book2("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));

        Stream<String> stream = books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase("Horror"))
                .peek(book->System.out.println("Filtered book " + book))
                .filter(book -> book.getRating() > 3)
                .map(book -> book.getName());
        //.collect(Collectors.toList());
        System.out.println("Filtering done!");
        collect(stream);
    }

    private static void collect(Stream<String> stream) {
        List<String> popularHorrorBooks = stream.collect(Collectors.toList());
        System.out.println("Collection done!");
        popularHorrorBooks.forEach(System.out::println);
    }
}
