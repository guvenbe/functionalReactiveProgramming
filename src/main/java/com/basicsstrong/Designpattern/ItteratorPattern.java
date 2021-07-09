package com.basicsstrong.Designpattern;

import java.util.*;

public class ItteratorPattern {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("John");
        list.add("Rohn");
        list.add("Shiva");

        Iterator itr = list.iterator();
        while (itr.hasNext()){
            System.out.println("Name: "+ itr.next());
        }
        System.out.println("Concreate iterator we get is :" + itr.toString());

        Set<String> set = new HashSet<>();
        set.add("Tom");
        set.add("John");
        set.add("Rohn");
        Iterator<String> setItr = set.iterator();
        while (setItr.hasNext()){
            System.out.println("Name: "+ setItr.next());
        }
        System.out.println("Concreate set iterator we get is :" + itr.toString());
    }
}
