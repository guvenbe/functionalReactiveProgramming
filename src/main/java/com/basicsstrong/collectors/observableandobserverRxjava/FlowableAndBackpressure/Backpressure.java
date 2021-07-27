package com.basicsstrong.collectors.observableandobserverRxjava.FlowableAndBackpressure;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;




public class Backpressure {
    public static void main(String[] args) {
        Observable.range(1, 1000000)
                .map(e -> {
                    System.out.println("Produced Item is : " + e  + " : " +Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                .subscribe(e -> {
                            sleep(100);
                            System.out.println("Consumed itme isd: " + e + " : " +Thread.currentThread().getName());
                        }
                );
        sleep(100000000);
    }

    private static void sleep(long milliSeconds){
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
