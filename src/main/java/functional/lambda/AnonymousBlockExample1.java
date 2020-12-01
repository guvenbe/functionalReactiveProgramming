package functional.lambda;

public class AnonymousBlockExample1 {
    public static void main(String[] args) {
        Thread t =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread executed!!");
            }
        });
        t.start();
    }
}
