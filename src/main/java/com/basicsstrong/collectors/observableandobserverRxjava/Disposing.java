package com.basicsstrong.collectors.observableandobserverRxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Disposing {

    private static final CompositeDisposable disp =new CompositeDisposable();
    public static void main(String[] args) throws InterruptedException {
        @NonNull
        Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS);

        @NonNull
        Disposable d = src.subscribe(e -> System.out.println("Observer 1:" + e));
        Thread.sleep(5000);
        d.dispose();
        src.subscribe(e->System.out.println("Observer 2:"+ e));

        Thread.sleep(10000);

        ///////////////////////////////////

        Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS);

        src2.subscribe(new Observer<Long>(){
            private Disposable d;
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                this.d = d;
            }

            @Override
            public void onNext(@NonNull Long aLong) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        //////////////////////////////////////////
        @NonNull
        Observable<Long> src3 = Observable.interval(1, TimeUnit.SECONDS);

        @NonNull
        Disposable d3 = src3.subscribe(e -> System.out.println("Observer x1:" + e));
        Disposable d4 = src3.subscribe(e -> System.out.println("Observer x2:" + e));
        Thread.sleep(5000);
        disp.addAll(d3,d4);
        disp.dispose();

        Thread.sleep(10000);

    }
}
