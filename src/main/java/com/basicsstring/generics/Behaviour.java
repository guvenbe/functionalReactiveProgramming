package com.basicsstring.generics;

import java.util.ArrayList;

public class Behaviour {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        l.add("bora");
        l.add("guven");
        l.add("hello");
        metod(l);
        System.out.println(l);
    }

    // This takes raw type
    private static void metod(ArrayList l) {
        l.add(10);
        l.add("see this");
        l.add(true);
    }
}