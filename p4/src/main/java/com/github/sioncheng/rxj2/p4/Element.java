package com.github.sioncheng.rxj2.p4;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class Element {

    public static void main(String[] args) {
        Observable.range(1, 10)
                .elementAt(3)
                .subscribe(System.out::println);

        Observable.range(1, 10)
                .ignoreElements()
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError");
                    }
                });
    }
}
