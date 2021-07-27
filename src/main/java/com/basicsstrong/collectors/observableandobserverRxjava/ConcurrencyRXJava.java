package com.basicsstrong.collectors.observableandobserverRxjava;

import io.reactivex.rxjava3.core.Observable;

public class ConcurrencyRXJava {
    public static void main(String[] args) {
        Observable<Object> source = Observable.create(e ->
                new Thread(() -> {
                    e.onNext("Hello");
                    e.onNext("RxJava");
                }
                ).start()
        );

        source
                .subscribe(e->System.out.println("Observer 1 :" + e + " Thread is :" + Thread.currentThread().getName()));

        source
                .subscribe(e->System.out.println("Observer 2 :" + e + " Thread is :" + Thread.currentThread().getName()));
    }
}
