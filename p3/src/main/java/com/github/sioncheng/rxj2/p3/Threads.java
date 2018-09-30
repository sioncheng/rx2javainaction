package com.github.sioncheng.rxj2.p3;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Threads {

    public static void main(String[] args) throws Exception {
        Observable.just("aa", "bbb")
                .observeOn(Schedulers.newThread())
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        System.out.println("map in " + Thread.currentThread().getName());
                        return s.length();
                    }
                })//.subscribeOn(Schedulers.single())
                .observeOn(Schedulers.newThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("accept in " + Thread.currentThread().getName());
                        System.out.println(integer);
                    }
                });

        TimeUnit.SECONDS.sleep(3);
    }
}
