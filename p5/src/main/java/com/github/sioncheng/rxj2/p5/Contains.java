package com.github.sioncheng.rxj2.p5;

import io.reactivex.Observable;

public class Contains {

    public static void main(String[] args) {
        Observable.just(1)
                .contains(1)
                .subscribe(System.out::println);

        Observable.empty()
                .contains(1)
                .subscribe(System.out::println);
    }
}
