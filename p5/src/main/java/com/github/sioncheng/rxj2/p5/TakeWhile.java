package com.github.sioncheng.rxj2.p5;

import io.reactivex.Observable;

public class TakeWhile {

    public static void main(String[] args) {
        Observable.range(1, 10)
                .takeWhile(x -> x < 3)
                .subscribe(System.out::println);
    }

}
