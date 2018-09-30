package com.github.sioncheng.rxj2.p4;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Window {

    public static void main(String[] args) {
        Observable.range(1, 10)
                .window(2)
                .subscribe(new Consumer<Observable<Integer>>() {
                    @Override
                    public void accept(Observable<Integer> integerObservable) throws Exception {
                        System.out.println("accept " + integerObservable);

                        integerObservable.subscribe(System.out::println);
                    }
                });
    }
}
