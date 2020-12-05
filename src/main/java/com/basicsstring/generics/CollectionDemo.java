package com.basicsstring.generics;

import java.util.ArrayList;

public class CollectionDemo {
    public static void main(String[] args) {
        //Raw type
        ArrayList list = new ArrayList();
        list.add("John");
        list.add(1);

        //This will throw class cast exception
        for (Object object: list) {
            String str = (String)object;
            System.out.println(str);
        }
  /////////////////////////////////////////////////////////////////
        //This is typesafe
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("John");
        list2.add("Bora");
        //list2.add(1); //<--- Compile will not allow this

        //This will throw class cast exception
        for (String object: list2) {
            String str = object;
            System.out.println(str);
        }

    }
}
