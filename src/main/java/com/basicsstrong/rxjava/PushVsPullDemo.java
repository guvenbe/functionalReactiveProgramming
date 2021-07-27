package com.basicsstrong.rxjava;

interface CallBackPushPull {
    void pushData(String data);
    void pushComplete();
    void pushError(Exception re);
}

public class PushVsPullDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread is running");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                new PushVsPullDemo().runningAsync(new CallBackPushPull() {
                    @Override
                    public void pushData(String data) {
                        System.out.println("Call back data: " + data);
                    }

                    @Override
                    public void pushComplete() {
                        System.out.println("Callback completed");
                    }

                    @Override
                    public void pushError(Exception ex) {
                        System.out.println("Call back error called, Got an exception :" + ex);
                    }
                });
            }
        };

        Thread t = new Thread(r);
        t.start();
        Thread.sleep(2000);
        System.out.println("Main thread completed");
    }
    public void runningAsync(CallBackPushPull callBack){
        System.out.println("I am running in separate thread");
        sleep(1000);
        callBack.pushData("Data1");
        callBack.pushData("Data2");
        callBack.pushData("Data3");

        callBack.pushError(new RuntimeException("Ooops"));
        callBack.pushComplete();
    }
    private void sleep(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
