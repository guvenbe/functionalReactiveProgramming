package com.basicsstrong.collectors.observableandobserverRxjava.schedular;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ComputationScheduler {
    public static void main(String[] args) throws InterruptedException {
        int numOfCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of Cores =" + numOfCores);
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow Mein")
                .subscribeOn(Schedulers.computation());
        src.subscribe(e->compute());
        src.subscribe(e->compute());
        src.subscribe(e->compute());
        src.subscribe(e->compute());

        Thread.sleep(50000);
    }

    public static void compute() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation done by : " + Thread.currentThread().getName());
    }
}
