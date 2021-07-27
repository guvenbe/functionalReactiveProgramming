package com.basicsstrong.rxjava;

import java.util.ArrayList;

interface SubjectLibrary {
    public void subscribeObserver(Observer ob);

    public void unsubscribeObserver(Observer ob);

    public void notifyObserver();

}

interface Observer {
    public void update(String avail);
}

class EndUser implements Observer{
    String name;

    public EndUser(String name, SubjectLibrary subject) {
        this.name = name;
        subject.subscribeObserver(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Avalibility changed from Sild out ot back in stock \n");
    }

    @Override
    public void update(String avail) {
        System.out.println("Hello " + name + "! we are glad to notify you that your book is now " + avail);

    }
}
class Book implements SubjectLibrary {

    private String name;
    private String type;
    private String author;
    private double price;
    private String inStock;
    private ArrayList<Observer> obsList = new ArrayList<Observer>();

    public Book(String name, String type, String author, double price, String inStock) {
        this.name = name;
        this.type = type;
        this.author = author;
        this.price = price;
        this.inStock = inStock;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
        System.out.println("Avalibility changed from Sold out ot back in stock \n");
        notifyObserver();
    }

    public ArrayList<Observer> getObsList() {
        return obsList;
    }

    public void setObsList(ArrayList<Observer> obsList) {
        this.obsList = obsList;
    }

    @Override
    public void subscribeObserver(Observer ob) {
        obsList.add(ob);

    }

    @Override
    public void unsubscribeObserver(Observer ob) {
        obsList.remove(ob);

    }

    @Override
    public void notifyObserver() {
        System.out.println(
                "Book name: " + this.name +
                        "Book Type : " + this.type +
                        "Price : " + this.price +
                        "Author :" + this.author +
                        ", oi now" + this.inStock +" So, please notify all users. \n"
        );
        for (Observer observer : obsList) {
            observer.update(this.inStock);
        }

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("name='").append(name).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", price=").append(price);
        sb.append(", inStock='").append(inStock).append('\'');
        sb.append(", obsList=").append(obsList);
        sb.append('}');
        return sb.toString();
    }
}

public class ObserverDesignPatternDemo {
    public static void main(String[] args) {
        Book book = new Book("Goosebumps", "Horro", "Xyz",200,"Soldout");
        EndUser user1 = new EndUser("Bob",book);
        EndUser user2 = new EndUser("Rob",book);
        System.out.println(book.getInStock());
        book.setInStock("In Stock");
    }
}
