package com.github.sioncheng.rxj2.p5;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class SkipUntil {

    public static void main(String[] args) throws Exception {
        Observable.intervalRange(1, 10, 0,100, TimeUnit.MILLISECONDS)
                .skipUntil(Observable.timer(200, TimeUnit.MILLISECONDS))
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(2);
    }
}
