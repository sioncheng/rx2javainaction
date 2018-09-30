package com.github.sioncheng.rxj2.p3;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class NewThread {

    public static void main(String[] args) throws Exception {
        System.out.println("main in thread : " + Thread.currentThread().getName());

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) {
                System.out.println("emmit in thread : " + Thread.currentThread().getName());
                observableEmitter.onNext("hello");
            }
        }).observeOn(Schedulers.newThread())
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("consume in thread : " + Thread.currentThread().getName());
                System.out.println(s);
            }
        });

        TimeUnit.SECONDS.sleep(2);
    }
}
