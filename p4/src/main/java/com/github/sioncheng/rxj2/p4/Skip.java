package com.github.sioncheng.rxj2.p4;

import io.reactivex.Observable;

public class Skip {

    public static void main(String[] args) {
        Observable.range(1, 10)
                .skip(2)
                .subscribe(System.out::println);

        Observable.range(1, 10)
                .skipLast(2)
                .subscribe(System.out::println);
    }
}
