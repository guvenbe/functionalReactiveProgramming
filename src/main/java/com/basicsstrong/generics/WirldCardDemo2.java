package com.basicsstrong.generics;

public class WirldCardDemo2 {
    public static void main(String[] args) {
        //DataNode(Integer, DataNode(Integer))
        DataNode<Integer> node2= new DataNode<>(20,null);
        DataNode<Integer> node1= new DataNode<>(35,node2);

        DataNode<Double> node222= new DataNode<>(20.5,null);
        DataNode<Double> node111= new DataNode<>(35.5,node222);

        DataNode<Number> node1111= new DataNode<>(35.5,null);
        node111.setNext(node2);

        //DataNode(Integer, DataNode(Integer))

        System.out.println(node1.toString());
        System.out.println(node111.toString());

    }
}
