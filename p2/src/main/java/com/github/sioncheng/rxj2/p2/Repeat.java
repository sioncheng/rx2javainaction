package com.github.sioncheng.rxj2.p2;

import io.reactivex.Observable;

public class Repeat {

    public static void main(String[] args) {
        Observable.just("hello")
                .repeat(3)
                .subscribe(System.out::println);
    }
}
