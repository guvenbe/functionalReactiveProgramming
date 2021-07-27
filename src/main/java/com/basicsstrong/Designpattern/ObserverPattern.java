package com.basicsstrong.Designpattern;

import java.util.ArrayList;
import java.util.Iterator;

class Book implements SubjectLibrary{
    private String name, type, author, inStock;
    private double price;
    private ArrayList<Observer> obList = new ArrayList<Observer>();

    public Book(String name, String type, String author,  double price, String inStock) {
        this.name = name;
        this.type = type;
        this.author = author;
        this.inStock = inStock;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
        System.out.println("Avalibility changed from Sild out ot back in stock \n");
        notifyObserver();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Observer> getObList() {
        return obList;
    }

    public void setObList(ArrayList<Observer> obList) {
        this.obList = obList;
    }

    @Override
    public void subsribeObserver(Observer ob) {
        obList.add(ob);

    }

    @Override
    public void unsubsribeObserver(Observer ob) {
        obList.remove(ob);
    }

    @Override
    public void notifyObserver() {
        System.out.println(
                "Book Name: " + this.name +
                " ,Book Type : " + this.type +
                " ,Price :" + this.price +
                ", Author : " + this.author +
                ", is now " + this.inStock + ". So, please notify all users.\n"

        );
       for (Observer ob : obList) {
           ob.update(this.inStock);
       }
    }
}

interface Observer{
    public void update(String avail);
}

interface SubjectLibrary{
    public void subsribeObserver(Observer ob);
    public void unsubsribeObserver(Observer ob);
    public void notifyObserver();
}

class EndUser implements Observer{
    String name;

    public EndUser(String name, SubjectLibrary subject) {
        this.name = name;
        subject.subsribeObserver(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(String avail) {
        System.out.println("Hello " + name + "! we are glad to notify you that book is availale");
    }
}
public class ObserverPattern {
    public static void main(String[] args) {
        Book book = new Book("Goosebumps","Horror", "Xyz", 200, "Sold out");
        EndUser user1 = new EndUser("Bob", book);
        EndUser user2 = new EndUser("Tom", book);
        ArrayList<Observer> subscribers = book.getObList();
        for(Iterator<Observer> itr = subscribers.iterator();itr.hasNext();){
            EndUser eu = (EndUser)itr.next();
            System.out.println(eu.getName() + " has subscribed for " + book.getName() + " Book");
        }

        System.out.println(book.getInStock());
        System.out.println("Book is now availale");

        book.setInStock("Back in Stock");

    }
}
