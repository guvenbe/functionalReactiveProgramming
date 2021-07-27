package com.basicsstrong.collectors.observableandobserverRxjava;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class EmissionsUsingSubject {
    public static void main(String[] args) {

        Subject<Object> subject = PublishSubject.create();
        Subject<Object> serialized = subject.toSerialized();
        serialized.subscribe(e-> System.out.println("Observer1 :" + e));
        serialized.subscribe(e-> System.out.println("Observer2 :" + e));

        serialized.onNext("Hello");
        serialized.onNext("BasicsStrong");
        serialized.onComplete();
        serialized.onNext("BasicsStrong");

    }
}
