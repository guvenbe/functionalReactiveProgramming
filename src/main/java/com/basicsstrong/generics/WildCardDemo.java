package com.basicsstrong.generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardDemo {

    public static void displayData(List<?> l){
        for (Object t : l) {
            System.out.println(t);

        }
    }

    public static void displayData2(List<? super Integer> l){
        for (Object t : l) {
            System.out.println(t);

        }
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Number> list2 = new ArrayList<>();
        list.add(34);
        list.add(57);
        list.add(22);

        list2.add(22.2);
        list2.add(2);
        displayData(list);

        displayData2(list);
        displayData2(list2);
    }
}
