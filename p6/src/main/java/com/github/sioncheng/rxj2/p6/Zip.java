package com.github.sioncheng.rxj2.p6;

import io.reactivex.Observable;

public class Zip {

    public static void main(String[] args) {
        Observable<Integer> observable1 = Observable.just(1,2,3,4);
        Observable<Integer> observable2 = Observable.just(11,22,33,44);

        Observable.zip(observable1, observable2, (x,y) -> x + y)
                .subscribe(System.out::println);

        Observable.zip(observable1, observable2, (x,y) -> x.toString() + y.toString())
                .subscribe(System.out::println);
    }
}
