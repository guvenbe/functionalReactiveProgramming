package com.basicsstrong.rxjava;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {
    public static void main(String[] args) {
        //observable
        Observable<String> source = Observable.create(
                e -> {
                    e.onNext("Hello");
                    e.onNext("RxJava");
                }
        );
        //Observer
        source.subscribe(e -> System.out.println("Observer 1 " + e + " Thread is :" + Thread.currentThread().getName()));
        source.subscribe(e -> System.out.println("Observer 2 " + e  + " Thread is :" + Thread.currentThread().getName()));
    }
}
