package com.github.sioncheng.rxj2.p2;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Timer {

    public static void main(String[] args) throws Exception {
        Observable.timer(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(3);
    }
}
