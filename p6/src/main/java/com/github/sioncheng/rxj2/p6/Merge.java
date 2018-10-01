package com.github.sioncheng.rxj2.p6;

import io.reactivex.Observable;

public class Merge {

    public static void main(String[] args) {
        Observable<Integer> observable1 = Observable.just(1,2,3,4);
        Observable<Integer> observable2 = Observable.just(11,22,33,44);

        Observable.merge(observable1, observable2).subscribe(System.out::println);
        observable1.mergeWith(observable2).subscribe(System.out::println);
    }
}
