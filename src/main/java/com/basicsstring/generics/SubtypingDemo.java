package com.basicsstring.generics;

import java.util.ArrayList;
import java.util.List;

public class SubtypingDemo {

    public static void main(String[] args) {

        Object o = new Object();
        Integer i =Integer.valueOf(1);
        o=i;
        System.out.println(o);

        List<Number> list = new ArrayList<>();
        list.add(Integer.valueOf(10));
        list.add(Double.valueOf(10.5));
        //list.add("hello")) <-- error not compatible not a child or subtype


    }
}
