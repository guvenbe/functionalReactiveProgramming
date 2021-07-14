package com.basicsstrong.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapOperation {
    public static void main(String[] args) {
        Stream<String> a = Stream.of("Hello ", "there! ");
        Stream<String> b = Stream.of("Learning ", "Java? ");
        Stream<Stream<String>> a1 = Stream.of(a, b);

        Stream.of(a,b).flatMap(e->e);

        Path p = Paths.get("/home/vagrant/IdeaProjects/functionalReactive/src/main/java/com/basicsstrong/Designpattern/streams/TheNoteBook.txt");
        try(Stream<String> notebook = Files.lines(p);) {

            List<String> collect = notebook
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .collect(Collectors.toList());
            collect.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
