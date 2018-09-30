package com.github.sioncheng.rxj2.p5;

import io.reactivex.Observable;

public class All {

    public static void main(String[] args) {
        Observable.just(1,2,3)
                .all(x -> x >0)
                .subscribe(System.out::println);

        Observable.just(1,2,3)
                .all(x -> x >3)
                .subscribe(System.out::println);
    }
}
