package com.basicsstrong.collectors.observableandobserverRxjava.schedular;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SingleScheduler {
    public static void main(String[] args) throws InterruptedException {
        int numOfCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of Cores =" + numOfCores);

        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow Mein")
                .subscribeOn(Schedulers.single());
        src.subscribe(e-> sensitiveTask());
        Thread.sleep(6000);
        src.subscribe(e-> sensitiveTask());
        src.subscribe(e-> sensitiveTask());
        src.subscribe(e-> sensitiveTask());
        src.subscribe(e-> sensitiveTask());
        src.subscribe(e-> sensitiveTask());

        Thread.sleep(500000);
    }

    public static void sensitiveTask() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Single Operation done by : " + Thread.currentThread().getName());
    }
}
