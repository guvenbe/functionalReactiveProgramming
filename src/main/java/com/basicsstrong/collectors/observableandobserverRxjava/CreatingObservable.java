package com.basicsstrong.collectors.observableandobserverRxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class CreatingObservable {
    public static void main(String[] args) {
        //create factory method
        Observable<Integer> source = Observable.create(
                e->{
                    e.onNext(10);
                    e.onNext(11);
                    e.onNext(12);
                    e.onComplete();

                }
        );

        source.subscribe(System.out::println);

        //just
        Observable<Integer> just = Observable.just(1,2,3);
        just.subscribe(System.out::println);

        //fromIterable
        List<String> list = List.of("Ram", "Shyam", "Mike");

        @NonNull
        Observable<String> fromIterable =
                Observable.fromIterable(list);
        fromIterable.subscribe(System.out::println);

        //range
        Observable.range(3,10).subscribe(s-> System.out.println("RECIEVED " + s));

        Observable<String> source2 = Observable.just("Orange", "Black", "Red");
        source2.subscribe(i->System.out.println(i), Throwable::printStackTrace,()-> System.out.println("Completed"));
        System.out.println();
        //good for infinite emmitions
        source2.subscribe(i->System.out.println(i), Throwable::printStackTrace);
        System.out.println();
        source2.subscribe(i-> System.out.println(i));

    }
}
