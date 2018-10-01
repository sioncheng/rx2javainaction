package com.github.sioncheng.rxj2.p6;

import io.reactivex.Observable;

public class StartWith {

    public static void main(String[] args) {
        Observable.just(1,2,3,4)
                .startWith(0)
                .subscribe(System.out::println);
    }
}
