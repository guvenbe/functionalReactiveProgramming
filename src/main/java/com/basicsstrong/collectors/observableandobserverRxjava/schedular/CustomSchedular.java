package com.basicsstrong.collectors.observableandobserverRxjava.schedular;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomSchedular {
    public static void main(String[] args) throws InterruptedException {
        int numOfCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of Cores =" + numOfCores);

        ExecutorService executor = Executors.newFixedThreadPool(20);
        Scheduler scheduler = Schedulers.from(executor);

        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow Mein")
                .subscribeOn(scheduler)
                .doFinally(executor::shutdown);

        src.subscribe(e-> compute());
        src.subscribe(e-> compute());
        src.subscribe(e-> compute());
        src.subscribe(e-> compute());
        src.subscribe(e-> compute());
        src.subscribe(e-> compute());

    }
    public static void compute() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("custom scheduling done by : " + Thread.currentThread().getName());
    }
}
