package com.basicsstrong.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ErasureDemo {
    public static void main(String[] args) {
        System.out.println(method1(5));


        //No error below. Type erasure
        ArrayList l1 = new ArrayList<String>();
        //ArrayList l1 = new ArrayList;
        l1.add(12);
        l1.add(true);
        l1.add("hello");
    }

    public static  String method1(Integer x){
        List<String> a = new LinkedList<>();
        // compiler made this
        //List a = new LinkedListl
        List b =a;
        b.add(x);
        return a.iterator().next();
        //compiler made this
        //return (String) a.iterator().next();

    }

    //Overloading will not work due to type erasure
//    public static void method2(ArrayList<String> l){
//
//    }

    public static void method2(ArrayList<Integer> l){

    }
}
