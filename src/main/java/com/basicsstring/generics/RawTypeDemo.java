package com.basicsstring.generics;

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

public class RawTypeDemo {
    public static void main(String[] args) {
        Box<Integer> genBox = new Box<>(List.of(1,2,3));
        for (Integer i: genBox.getA()) {
            System.out.println(i);
        }

        //Avoid this maybe not type safe
        Box rawBox = new Box(List.of(1,2,3,"My String")); // <-- No restriction


    }
}
