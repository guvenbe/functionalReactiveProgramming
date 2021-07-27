package com.basicsstrong.collectors.observableandobserverRxjava;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class FlatmapConcatMap {
    public static void main(String[] args) {
        List<String> list = List.of("Hello", "Reactive", "Programming");
        Observable.fromIterable(list)
                .flatMap(e->Observable.fromArray(e.split("")))
                        .subscribe(System.out::println);

        System.out.println("------------------------------------------------");
        Observable.fromIterable(list)
                .concatMap(e->Observable.fromArray(e.split("")))
                .subscribe(System.out::println);
    }
}