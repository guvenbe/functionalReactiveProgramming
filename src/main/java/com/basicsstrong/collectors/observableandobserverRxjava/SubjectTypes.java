package com.basicsstrong.collectors.observableandobserverRxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.*;

import java.util.concurrent.TimeUnit;


public class SubjectTypes {
    public static void main(String[] args) throws InterruptedException {

        int numOfCores = Runtime.getRuntime().availableProcessors();
        System.out.println(numOfCores);
        //Publish Subject Type
        System.out.println("------------------Publish Subject----------------");
        Subject<String> subject = PublishSubject.create();
        subject.subscribe(e->System.out.println("Subscriber 1:" +e));
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        subject.subscribe(e->System.out.println("Subscriber 2:" +e));

        subject.onNext("d");
        subject.onNext("e");
        subject.onComplete();

        //Replay Subject
        System.out.println("------------------replay subject----------------");
        Subject<String> subject2 = ReplaySubject.create();
        subject2.subscribe(e->System.out.println("Subscriber 1:" +e));
        subject2.onNext("a");
        subject2.onNext("b");
        subject2.onNext("c");

        subject2.subscribe(e->System.out.println("Subscriber 2:" +e));

        subject2.onNext("d");
        subject2.onNext("e");
        subject2.onComplete();

        //Behaviour Subject
        System.out.println("------------------Behaviour subject----------------");
        Subject<String> subject3 = BehaviorSubject.create();
        subject3.subscribe(e->System.out.println("Subscriber 1:" +e));
        subject3.onNext("a");
        subject3.onNext("b");
        subject3.onNext("c");

        subject3.subscribe(e->System.out.println("Subscriber 2:" +e));

        subject3.onNext("d");
        subject3.onNext("e");
        subject3.onComplete();

        //Async Subject
        System.out.println("------------------Async subject----------------");
        Subject<String> subject4 = AsyncSubject.create();
        subject4.subscribe(e->System.out.println("Subscriber 1:" +e));
        subject4.onNext("a");
        subject4.onNext("b");
        subject4.onNext("c");

        subject4.subscribe(e->System.out.println("Subscriber 2:" +e));

        subject4.onNext("d");
        subject4.onNext("e");
        subject4.onComplete();

        //Unicast Subject
        System.out.println("------------------Unicast subject----------------");
        Subject<String> subject5 = UnicastSubject.create();
        subject5.subscribe(e->System.out.println("Subscriber 1:" +e));
        subject5.onNext("a");
        subject5.onNext("b");
        subject5.onNext("c");
        //only once subscriber is allowed
        //subject5.subscribe(e->System.out.println("Subscriber 2:" +e));

        subject5.onNext("d");
        subject5.onNext("e");
        subject5.onComplete();

        Subject<Long> subject6 = UnicastSubject.create();
        Observable.interval(500 , TimeUnit.MILLISECONDS)
        .subscribe(subject6);
        Thread.sleep(2000);
        subject6.subscribe(e->System.out.println("Subscriber 1:" +e));
        Thread.sleep(2000);
    }
}

