package com.basicsstrong.generics;

import java.util.Arrays;
import java.util.List;

//Any Type that extends NUMBER
class DataSorter<T extends Number>{
    private List<T> list;

    public DataSorter(List<T> list) {
        this.list = list;
    }
    
    public void getSortedData(){
        list.sort(null); //<-- Natural sorting
        for (T t : list) {
            System.out.println(t);
        }
    }
}
interface IBound1{}
interface IBound2{}
class CBound implements IBound1, IBound2{}
public class BoundedTypeDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,50,8,9);
        List<String> slist = Arrays.asList("Hello", "There", "Java");
        List<Double> dlist = Arrays.asList(11.2, 2.4, 44.0, 56.8);

        DataSorter<Integer> sorter1 = new DataSorter<>(list);
        DataSorter<Double> sorter3 = new DataSorter<>(dlist);
        //DataSorter<String> sorter2 = new DataSorter<>(slist); // <-- This will not work bound to number or subtype

        sorter1.getSortedData();
//        sorter2.getSortedData();
        sorter3.getSortedData();

        getSortedData(list);
        getSortedData(dlist);

        CBound b1 = new CBound();


    }

    public static <T extends Number> void getSortedData(List<T> list){
        list.sort(null);
        for (T t : list) {
            System.out.println(t);
        }
    }
    public  <T extends IBound1 &IBound2> void  someFunc(T list){}
}
