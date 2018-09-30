package com.github.sioncheng.rxj2.p5;

import io.reactivex.Observable;

public class DefaultIfEmpty {

    public static void main(String[] args) {
        Observable.just(1)
                .defaultIfEmpty(100)
                .subscribe(System.out::println);

        Observable.empty()
                .defaultIfEmpty(100)
                .subscribe(System.out::println);
    }
}
