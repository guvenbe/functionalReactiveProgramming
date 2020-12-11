package com.basicsstring.generics.functional.depth;

public class RefrentialTransparency {
    public static void main(String[] args) {

        //same result. Hence refrentialy transparent
        int result = add(2, multiply(2,4));
        System.out.println(result);
        result = add(2, 5);
        System.out.println(result);
        result = add(2, multiply(2,multiply(2,2)));
        System.out.println(result);
    }

    public static int add(int a, int b){
        return a + b;
    }

    public static int multiply(int a, int b){
        //The print changes output
        //System.out.println("Multiplying a and b :" + a +", "+ b);
        return a*b;
    }
}

