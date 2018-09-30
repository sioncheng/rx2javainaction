package com.github.sioncheng.rxj2.p4;

import io.reactivex.Observable;

public class Take {

    public static void main(String[] args) {
        Observable.range(1, 10)
                .take(2)
                .subscribe(System.out::println);

        Observable.range(1, 10)
                .takeLast(2)
                .subscribe(System.out::println);
    }
}
