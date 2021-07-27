package com.basicsstrong.collectors.observableandobserverRxjava.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Book4 {


    private String name;
    private String author;
    private String genre;
    private double rating;


    public Book4(String name, String author, String genre, double rating) {
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
public class StreamsIntroduction {
    public static void main(String[] args) {
        List<Book4> books = new ArrayList<>();
        List<Book4> popularHorrorBooks = new ArrayList<>();
        for (Book4 book : books) {
            if(book.getGenre().equalsIgnoreCase("Horror") & book.getRating()>3){
                popularHorrorBooks.add(book);
            }
        }
        List<Book4> popularHorror = books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase("Horror"))
                .filter(book -> book.getRating() > 3)
                .collect(Collectors.toList());
    }
}
