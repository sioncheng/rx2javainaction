package com.github.sioncheng.rxj2.p1;

import io.reactivex.subjects.BehaviorSubject;

public class Behavior {

    public static void main(String[] args) {
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();

        behaviorSubject.onNext("b1");
        behaviorSubject.onNext("b2");

        behaviorSubject.subscribe(System.out::println);

        behaviorSubject.onNext("b3");
        behaviorSubject.onNext("b4");
    }

}
