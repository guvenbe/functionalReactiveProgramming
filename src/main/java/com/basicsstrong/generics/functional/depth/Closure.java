package com.basicsstrong.generics.functional.depth;
interface Task{
    void doTask();
}
public class Closure {
    public static void main(String[] args) {
        int val =111;
        //val=112; //cant do this, val must be final or effectively final
        Task lambda = () ->{
            //val=122; //Cant do this
            System.out.println(val); //val must be final or effectively final
            System.out.println("Task completed");
        };
        printValue(lambda);
    }

    private static void printValue(Task lambda) {
        //val is not here but JRE is keeping track of it from the closure
        lambda.doTask();
    }
}
