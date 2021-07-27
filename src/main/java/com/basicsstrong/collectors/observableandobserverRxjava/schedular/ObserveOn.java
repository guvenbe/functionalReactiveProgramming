package com.basicsstrong.collectors.observableandobserverRxjava.schedular;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObserveOn {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow Mein")
                .subscribeOn(Schedulers.computation())
                .map(e->e.toUpperCase())
                .doOnNext(e-> System.out.println(Thread.currentThread().getName()))
                .observeOn(Schedulers.newThread())
                .filter(e->e.startsWith("P"))
                .observeOn(Schedulers.io())
                .subscribe(e->print(e));

        Thread.sleep(6000);
    }

    private static void print(String element) {
        System.out.println(element + " : Printed by :" +Thread.currentThread().getName());
    }
}
