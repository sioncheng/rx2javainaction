package com.github.sioncheng.rxj2.p1;

import io.reactivex.subjects.ReplaySubject;

public class Reply {

    public static void main(String[] args) {
        ReplaySubject<String> replaySubject = ReplaySubject.create();

        replaySubject.onNext("reply1");
        replaySubject.onNext("reply2");
        replaySubject.onNext("reply3");

        replaySubject.subscribe(System.out::println);

        replaySubject.onNext("reply4");
        replaySubject.onNext("reply5");
    }
}
