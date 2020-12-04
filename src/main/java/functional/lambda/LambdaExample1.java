package functional.lambda;

/*
 * Function has 4 Properties
 * 1) Name of the function
 * 2) Parameters List
 * 3) Body of the function
 * 4) Return Type
 * */
public class LambdaExample1 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Thread Executed Lambda way!"));
        t.start();
    }
}
