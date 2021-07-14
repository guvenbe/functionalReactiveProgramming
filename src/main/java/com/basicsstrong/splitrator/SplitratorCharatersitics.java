package com.basicsstrong.splitrator;

import java.util.ArrayList;
import java.util.Spliterator;

public class SplitratorCharatersitics {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.add(9);
        list.add(0);
        list.add(1);

        int bits = list.stream().spliterator().characteristics();
        System.out.println(Integer.bitCount(bits));

        //OR
        System.out.println((Integer.bitCount(bits|Spliterator.ORDERED))==Integer.bitCount(bits));

        //AND

        System.out.println((bits& Spliterator.ORDERED)==Spliterator.ORDERED);

        Spliterator<Integer> spliterator = list.stream().spliterator();
        System.out.println(spliterator.hasCharacteristics(Spliterator.ORDERED));


    }
}
