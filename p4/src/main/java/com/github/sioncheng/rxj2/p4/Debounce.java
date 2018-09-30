package com.github.sioncheng.rxj2.p4;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import java.util.concurrent.TimeUnit;

public class Debounce {

    public static void main(String[] args) {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            boolean b = false;
            int c = 0;
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                for (int i = 0 ; i < 10; i++) {
                    int sleep = b ? 100 : 50;
                    b = !b;

                    TimeUnit.MILLISECONDS.sleep(sleep);
                    observableEmitter.onNext(c++);
                }
            }
        }).debounce(60, TimeUnit.MILLISECONDS).subscribe(System.out::println);
    }
}
