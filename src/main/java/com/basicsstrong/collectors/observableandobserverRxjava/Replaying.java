package com.basicsstrong.collectors.observableandobserverRxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Replaying {
    public static void main(String[] args) throws InterruptedException {
        @NonNull
        Observable<@NonNull Long> src = Observable.interval(1, TimeUnit.SECONDS)
                .replay()
                .autoConnect();

        src.subscribe(e -> System.out.println("Observer 1: " + e));
        Thread.sleep(5000);
        src.subscribe(e -> System.out.println("Observer 2: " + e));
        Thread.sleep(3000);
        System.out.println("----------------cached------------------");
        @NonNull
        Observable<@NonNull Long> src2 = Observable.interval(1, TimeUnit.SECONDS)
                .replay(1,1, TimeUnit.SECONDS) //cache one element
                .autoConnect();

        src2.subscribe(e -> System.out.println("Observer cached 1: " + e));
        Thread.sleep(5000);
        src2.subscribe(e -> System.out.println("Observer cached 2: " + e));
        Thread.sleep(3000);
    }
}
