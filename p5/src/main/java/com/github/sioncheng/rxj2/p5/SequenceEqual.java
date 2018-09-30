package com.github.sioncheng.rxj2.p5;

import io.reactivex.Observable;

public class SequenceEqual {

    public static void main(String[] args) {
        Observable<Integer> observable1 = Observable.just(1,3);
        Observable<Integer> observable2 = Observable.just(3,1);
        Observable<Integer> observable3 = Observable.just(1,3);

        Observable.sequenceEqual(observable1, observable2).subscribe(System.out::println);
        Observable.sequenceEqual(observable1, observable3).subscribe(System.out::println);
    }
}
