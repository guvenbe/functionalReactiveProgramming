package com.basicsstrong.generics.functional.depth;

public class TailCallRecursion {

    public static void main(String[] args) {
        System.out.println(reFact(4));
        System.out.println(tailRefact(4, 1));
    }

    /*
     * stack1       1
     * stack2       2 * reFact(1)
     * stack1       3 * reFact(2)
     * stack0       4 * reFact(3)
     * */

    public static long reFact(int n) {
        if (n <= 1)
            return 1;
        else
            return n * reFact(n - 1);
    }



    /*
    * accumalated        return 1*2*3*4  //Tail recurtion not supported in java
    * accumalated        tailRefact(1, 2*3*4)
    * accumalated        tailRefact(2, 3*4)
    * accumalated        tailRefact(3, 4)
    * */

    public static long tailRefact(int n, int a) {
        if (n <= 1)
            return a;
        else
            return tailRefact(n - 1, n * a);
    }
}
