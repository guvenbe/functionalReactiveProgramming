package com.basicsstrong.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Book {


    private String name;
    private String author;
    private String genre;
    private double rating;


    public Book(String name, String author, String genre, double rating) {
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

public class b4Java8Demo {
    public static void main(String[] args) {
        //before java 8
        List<Book2> books = new ArrayList<>();
        List<Book2> popularHorrorBooks = new ArrayList<>();
        for (Book2 book : books) {
            if(book.getGenre().equalsIgnoreCase("Horror") && book.getRating()>3){
                popularHorrorBooks.add(book);
            }

        }

        //After java 8
        List<Book2> collect = books.stream() //source
                .filter(book -> book.getGenre().equalsIgnoreCase("Horror"))//intemediate operations
                .filter(book -> book.getRating()>3)
                .collect(Collectors.toList());//terminal operation
        //1. source
        Stream<Book2> stream = books.stream();
        //2. Intermediate operation
        Stream<Book2> horrorBooks = stream.filter((book) -> book.getGenre().equalsIgnoreCase("Horror"));
        //3. Intermediate operation
        Stream<Book2> popularHorrorBooksStream = horrorBooks.filter((book) -> book.getRating() > 3);
        //4. Terminal operation
        List<Book2> collect1 = popularHorrorBooksStream.collect(Collectors.toList());

    }
}
