package com.github.sioncheng.rxj2.p5;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Amb {

    public static void main(String[] args) {
        Observable.ambArray(Observable.just(1),
                Observable.range(1,10)
        ).subscribe(System.out::println);

        System.out.println();

        Observable.ambArray(Observable.just(1).delay(1, TimeUnit.SECONDS),
                Observable.range(1,10)
        ).subscribe(System.out::println);

    }
}
