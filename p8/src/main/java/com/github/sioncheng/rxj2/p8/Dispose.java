package com.github.sioncheng.rxj2.p8;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Dispose {

    public static void main(String[] args) throws Exception {

         Disposable disposable = Observable.interval(100, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

         TimeUnit.SECONDS.sleep(1);

         disposable.dispose();

         TimeUnit.SECONDS.sleep(1);
    }
}
