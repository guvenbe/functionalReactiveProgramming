package com.basicsstrong.collectors.observableandobserverRxjava;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class MergeAndConcat {
    public static void main(String[] args) throws InterruptedException {
//        Observable<String> src1 = Observable.just("Ella", "Alexa", "Lily");
//        Observable<String> src2 = Observable.just("Priya", "Chloe");
        Observable<String> src1 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src1 :" + e);
        Observable<String> src2 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src2 :" + e);

        Observable.merge(src1, src2)
                .subscribe(e -> System.out.println("Received merge: " + e));
        Thread.sleep(10000);

        Observable.concat(src1, src2)
                .subscribe(e -> System.out.println("Received concat : " + e));
        //also
        src1.concatWith(src2).subscribe(e -> System.out.println("Received concat : " + e));
        Thread.sleep(20000);
    }
}
