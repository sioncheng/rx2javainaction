package com.github.sioncheng.rxj2.p1;

import io.reactivex.subjects.PublishSubject;

public class Publish {

    public static void main(String[] args) {
        PublishSubject<String> publishSubject = PublishSubject.create();

        publishSubject.onNext("pub1");
        publishSubject.onNext("pub2");

        publishSubject.subscribe(System.out::println);

        publishSubject.onNext("pub3");
        publishSubject.onNext("pub4");
        publishSubject.onNext("pub5");
    }
}
