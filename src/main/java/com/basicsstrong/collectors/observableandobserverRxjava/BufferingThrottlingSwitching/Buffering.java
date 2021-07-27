package com.basicsstrong.collectors.observableandobserverRxjava.BufferingThrottlingSwitching;

import io.reactivex.rxjava3.core.Observable;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class Buffering {
    public static void main(String[] args) throws InterruptedException {
        Observable.range(1,30)
                .buffer(4, HashSet::new)
                .subscribe(System.out::println);

        Observable.range(1,30)
                .buffer(4, 7)  //1,2,3,4...8,9,10,11...15,16,17,18
                .subscribe(System.out::println);

        System.out.println("-------------------------------------");

        Observable.interval(500, TimeUnit.MILLISECONDS)
                .buffer(1,TimeUnit.SECONDS, 2)
            .subscribe(System.out::println);
        Thread.sleep(8000);

        System.out.println("-------------------------------------");
        Observable<Long> interval = Observable.interval(500, TimeUnit.MILLISECONDS);

        Observable
                .interval(1000, TimeUnit.MILLISECONDS)
                .buffer(interval)
                .subscribe(System.out::println);
        Thread.sleep(8000);

        System.out.println("----------------Window---------------------");
        Observable
                .interval(1000, TimeUnit.MILLISECONDS)
                .window(interval)
                .subscribe(System.out::println);
        Thread.sleep(8000);

    }
}
