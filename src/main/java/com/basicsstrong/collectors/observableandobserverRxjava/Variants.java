package com.basicsstrong.collectors.observableandobserverRxjava;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Variants {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("Alex", "Justin", "Jack");
        Observable<String> source2 = Observable.empty();

        //single
        source.first("Name").subscribe(System.out::println);

        Single.just("Alex").subscribe(System.out::println);

        //maybe
        source.firstElement()
                .subscribe(System.out::println);
        source2.firstElement() //maybe
                .subscribe(System.out::println, e->e.printStackTrace(), ()-> System.out.println("Completed"));

        //completable
        Completable complete = Completable.complete();
        System.out.println();
        complete.subscribe(()->System.out.println("Completed"));

        Completable.fromRunnable(()-> System.out.println("Some Process executing"))
        .subscribe(()-> System.out.println("The process executed successfully"));
    }
}
