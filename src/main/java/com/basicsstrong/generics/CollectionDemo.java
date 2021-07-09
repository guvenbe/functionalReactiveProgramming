package com.basicsstrong.generics;

import java.util.ArrayList;
import java.util.HashMap;


class Bin<D, W>{
    private D dryTrash;
    private W wetTrashl;

    public D getDryTrash() {
        return dryTrash;
    }

    public void setDryTrash(D dryTrash) {
        this.dryTrash = dryTrash;
    }

    public W getWetTrashl() {
        return wetTrashl;
    }

    public void setWetTrashl(W wetTrashl) {
        this.wetTrashl = wetTrashl;
    }
}
public class CollectionDemo {
    public static void main(String[] args) {
        //Raw type
        ArrayList list = new ArrayList();
        list.add("John");
        list.add(1);

        //This will throw class cast exception
//        for (Object object: list) {
//            String str = (String)object;
//            System.out.println(str);
//        }
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

        HashMap<Integer,String> map = new HashMap<>();

        Bin<String, Integer> bin = new Bin<>();
        bin.setDryTrash("asasasasasasawwewew");
        bin.setWetTrashl(12234);

        System.out.println("Dry Trash:" + bin.getDryTrash() + " Wet Trash:" + bin.getWetTrashl());

    }
}
