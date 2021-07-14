package com.basicsstrong.splitrator;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class BookSpliterator implements Spliterator<Book2> {

    private String name;
    private String author;
    private String genre;
    private double rating;
    private Spliterator<String> baseSpliterator;

    public BookSpliterator(Spliterator<String> baseSpliterator) {
        this.baseSpliterator = baseSpliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Book2> action) {
        if(this.baseSpliterator.tryAdvance(name -> this.name = name) &&
                this.baseSpliterator.tryAdvance(author -> this.author = author) &&
                this.baseSpliterator.tryAdvance(genre -> this.genre = genre) &&
                this.baseSpliterator.tryAdvance(rating -> this.rating = Double.valueOf(rating))) {

            action.accept(new Book2(this.name, this.author, this.genre, this.rating));
            return true;

        }
        return false;
    }

    @Override
    public Spliterator<Book2> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return baseSpliterator.estimateSize() / 4;
    }

    @Override
    public int characteristics() {
        return baseSpliterator.characteristics();
    }

}

class Book2 {


    private String name;
    private String author;
    private String genre;
    private double rating;


    public Book2(String name, String author, String genre, double rating) {
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


