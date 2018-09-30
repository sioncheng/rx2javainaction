package com.github.sioncheng.rxj2.p4;

import io.reactivex.Observable;

public class First {

    public static void main(String[] args) {
        Observable.range(1, 10)
                .first(100)
                .subscribe(System.out::println);

        Observable.range(1, 0)
                .first(100)
                .subscribe(System.out::println);
    }
}
