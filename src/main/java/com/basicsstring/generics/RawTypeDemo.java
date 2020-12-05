package com.basicsstring.generics;

import java.util.ArrayList;
import java.util.List;

class Box<T>{
    private List<T> a;

    public Box(List<T> a) {
        this.a = a;
    }

    public List<T> getA() {
        return a;
    }

    public void setA(List<T> a) {
        this.a = a;
    }
}

class SquareBox<T> extends Box<T>{

    public SquareBox(List<T> a) {
        super(a);
    }
}
public class RawTypeDemo {
    public static void main(String[] args) {
        Box<Integer> genBox = new Box<>(List.of(1,2,3));
        for (Integer i: genBox.getA()) {
            System.out.println(i);
        }

        //Avoid this maybe not type safe
        Box rawBox = new Box(List.of(1,2,3,"My String")); // <-- No restriction

        List<Number> list = new ArrayList<>();
        list.add(Integer.valueOf(10));
        list.add(Double.valueOf(10.5));

        List<Box<Integer>> boxList = new ArrayList<>();
        boxList.add(new Box<>(List.of(1,2,3)));
        boxList.add(new Box<>(List.of(6,2,3)));
        boxList.add(new SquareBox<>(List.of(4,5,6)));

        //Subtyping only work if Type is the same
        //List<Number> l1 = new ArrayList<Integer>(); //<--Does not work
        //ArrayList<Number> l1 = new ArrayList<Integer>(); //<--Does not work
        List<Integer> l1 = new ArrayList<Integer>();


    }
}
