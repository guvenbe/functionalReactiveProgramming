package com.basicsstrong.collectors.observableandobserverRxjava.schedular;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class IOScheduler {
    public static void main(String[] args) throws InterruptedException {
        int numOfCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of Cores =" + numOfCores);
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow Mein")
                .subscribeOn(Schedulers.io());
        src.subscribe(e-> ioOperation());
        src.subscribe(e-> ioOperation());
        src.subscribe(e-> ioOperation());
        src.subscribe(e-> ioOperation());
        src.subscribe(e-> ioOperation());
        src.subscribe(e-> ioOperation());

        Thread.sleep(500000);
    }

    public static void ioOperation() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("IO Operation done by : " + Thread.currentThread().getName());
    }
}
