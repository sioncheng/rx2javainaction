package com.github.sioncheng.rxj2.p4;

import io.reactivex.Observable;

public class Distinct {

    public static void main(String[] args) {
        Observable.just(1,1,2,3,1,2,3,4,5)
                .distinct()
                .subscribe(System.out::println);
        System.out.println();

        Observable.just(1,1,2,2)
                .distinct()
                .subscribe(System.out::println);
        System.out.println();

        Observable.just(1,1,2,3,1,2,3,5)
                .distinctUntilChanged()
                .subscribe(System.out::println);
    }
}
