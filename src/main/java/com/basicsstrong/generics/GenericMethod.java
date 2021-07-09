package com.basicsstrong.generics;

import java.util.List;

class BoxWithGenericConstructor{
    private List a;

    public  <T> BoxWithGenericConstructor(List<T> a) {
        this.a = a;
    }

    public List getA() {
        return a;
    }

    public void setA(List a) {
        this.a = a;
    }

}
public class GenericMethod {

    public static <T> String concat(T data){
        return "Data is : " + data;
    }

    public static void main(String[] args) {
        System.out.println(concat("my data"));
        System.out.println(concat("1234"));

        BoxWithGenericConstructor  b1 = new BoxWithGenericConstructor(List.of(1,2,4));
    }
}
