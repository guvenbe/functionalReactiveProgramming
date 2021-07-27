package com.basicsstrong.collectors.observableandobserverRxjava.schedular;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOn {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow Mein")
                .subscribeOn(Schedulers.computation())
                .map(e->e.toUpperCase())
                .subscribeOn(Schedulers.newThread())
                .filter(e->e.startsWith("P"))
                .subscribe(e->print(e));

        Thread.sleep(6000);
    }

    private static void print(String element) {
        System.out.println(element + " : Printed by :" +Thread.currentThread().getName());
    }
}
