package com.github.sioncheng.rxj2.p2;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;

import java.util.concurrent.Callable;

public class Defer {

    public static void main(String[] args) {
        Observable observable = Observable.defer(new Callable<ObservableSource<?>>() {
            @Override
            public ObservableSource<?> call() throws Exception {
                return Observable.just("hello");
            }
        });

        Observable<String> observable1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("hello");
            }
        });

        observable.subscribe(System.out::println);
        observable1.subscribe(System.out::println);
    }
}
