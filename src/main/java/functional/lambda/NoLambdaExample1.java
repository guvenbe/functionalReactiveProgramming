package functional.lambda;

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread executed!");
    }
}

public class NoLambdaExample1 {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread t = new Thread(runnable);
        t.start();
    }
}
