package com.basicsstrong.collectors.observableandobserverRxjava.schedular;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TheFlatMap {
    //This is processed by computation thread in parallel
    public static void main(String[] args) throws InterruptedException {
        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow Mein")
                .flatMap(e->Observable.just(e)
                .subscribeOn(Schedulers.computation())
                .map(str->compute(str)))
                .subscribe(System.out::println);
        Thread.sleep(7000);
    }

    private static String compute(String element) {
      String s= element + " : Printed by :" +Thread.currentThread().getName();
      return s;
    }
}
