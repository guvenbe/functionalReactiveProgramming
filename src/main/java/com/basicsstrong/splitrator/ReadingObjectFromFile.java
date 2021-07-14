package com.basicsstrong.splitrator;

import java.awt.print.Book;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class Book3 {


    private String name;
    private String author;
    private String genre;
    private double rating;


    public Book3(String name, String author, String genre, double rating) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book [name=" + name + ", Author=" + author + ", genre=" + genre + ", rating=" + rating + "]";
    }
}

public class ReadingObjectFromFile {
    public static void main(String[] args) {
        Path path = Paths.get("/home/vagrant/IdeaProjects/functionalReactive/src/main/java/com/basicsstrong/splitrator/Books.txt");
        try (Stream<String> lines = Files.lines(path);) {
            Spliterator<String> baseSpliterator = lines.spliterator();
            BookSplitrator splitrator = new BookSplitrator(baseSpliterator);

            Stream<Book3> stream = StreamSupport.stream(splitrator, false);
            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }
}

class BookSplitrator implements Spliterator<Book3> {

    private String name;
    private String author;
    private String genre;
    private double rating;
    private Spliterator<String> baseSplitrator;

    public BookSplitrator(Spliterator<String> baseSplitrator) {
        this.baseSplitrator = baseSplitrator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Book3> action) {
        if (this.baseSplitrator.tryAdvance(name -> this.name = name) &&
                this.baseSplitrator.tryAdvance(author -> this.author = author) &&
                this.baseSplitrator.tryAdvance(genre -> this.genre = genre) &&
                this.baseSplitrator.tryAdvance(rating -> this.rating = Double.valueOf(rating))) {

            action.accept(new Book3(this.name, this.author, this.genre, this.rating));
            return true;
        }

        return false;
    }

    @Override
    public Spliterator<Book3> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return baseSplitrator.estimateSize()/4;
    }

    @Override
    public int characteristics() {
        return baseSplitrator.characteristics();
    }
}
