package com.basicsstrong.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

public class StreamsDemo {
    public static void main(String[] args) {
        List<Book2> books = new ArrayList<>();
        books.add(new Book2("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
        books.add(new Book2("The Notebook", "Nicholas Sparks", "Romance", 4.10));
        books.add(new Book2("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
        books.add(new Book2("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));

        List<Book2> popularHorrorBooks = books.stream() //source
                .filter(book -> book.getGenre().equalsIgnoreCase("Horror"))//intemediate operations
                .filter(book -> book.getRating()>3)
                .collect(Collectors.toList());//terminal operation

        popularHorrorBooks.forEach(System.out::println);


        List<Book2> popularRomanticBooks = books.stream() //source
                .filter(book -> book.getGenre().equalsIgnoreCase("Romance"))//intemediate operations
                .filter(book -> book.getRating()>3)
                .collect(Collectors.toList());//terminal operation

        popularRomanticBooks.forEach(System.out::println);

    }
}
