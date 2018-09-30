package com.github.sioncheng.rxj2.p4;

import io.reactivex.Observable;

public class Filter {

    public static void main(String[] args) {
        Observable.range(1,10)
                .filter(x -> x % 2 == 0)
                .subscribe(System.out::println);
    }
}
