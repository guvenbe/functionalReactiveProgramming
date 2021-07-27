package com.basicsstrong.collectors.observableandobserverRxjava.FlowableAndBackpressure;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;


public class FlowableWithSubsriberDemo {
    public static void main(String[] args) {
        Flowable.range(1, 1000000)
                .map(e -> {
                    System.out.println("Produced Item is : " + e + " : " + Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<Integer>() {

                               Subscription s;
                               AtomicInteger count = new AtomicInteger(0);

                               @Override
                               public void onSubscribe(Subscription s) {
                                   this.s = s;
                                   System.out.println("Asking for 20 items");
                                   s.request(20);
                               }

                               @Override
                               public void onNext(Integer t) {
                                    if(count.getAndIncrement() %20==0){
                                        System.out.println("Asking for next 20 items");
                                        s.request(20);
                                    }
                                   System.out.println("The subscriber consumed :" + t);
                                   sleep(100);
                               }

                               @Override
                               public void onError(Throwable t) {
                                    t.printStackTrace();
                               }

                               @Override
                               public void onComplete() {
                                   System.out.println("Completed");
                               }

                           }
                );
        sleep(100000000);
    }

    private static void sleep(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
