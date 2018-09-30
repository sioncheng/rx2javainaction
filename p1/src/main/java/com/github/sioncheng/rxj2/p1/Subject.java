package com.github.sioncheng.rxj2.p1;

import io.reactivex.subjects.AsyncSubject;

public class Subject {

    public static void main(String[] args) {
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.onNext("string1");
        subject.onNext("string2");
        subject.onComplete();

        subject.subscribe(System.out::println);
    }
}
