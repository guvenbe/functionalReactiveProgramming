package com.basicsstrong.generics.functional.depth;

public class Currying {
    public static void main(String[] args) {
        Function<Integer, Function<Integer, Function<Integer, Integer>>> fun1 = u -> v -> w -> u + v + w;
        Function<Integer, Function<Integer, Integer>> fun2 = fun1.apply(1); //
        Function<Integer, Integer> fun3 = fun2.apply(2);//v
        Integer sum = fun3.apply(3);//w
        System.out.println(sum);

        //or
        Integer sum2 = fun1.apply(1).apply(2).apply(3);
        System.out.println(sum2);

    }
}
