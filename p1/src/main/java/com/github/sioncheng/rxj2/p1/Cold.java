package com.github.sioncheng.rxj2.p1;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Cold {

    public static void main(String[] args) {
        Consumer<Long> consumer1 = new Consumer<Long>() {
            @Override
            public void accept(Long aLong) {
                System.out.println("consumer1 " + aLong);
            }
        };

        Consumer<Long> consumer2 = new Consumer<Long>() {
            @Override
            public void accept(Long aLong) {
                System.out.println("consumer2 " + aLong);
            }
        };

        Executor executor = Executors.newFixedThreadPool(2);

        Observable<Long> observable = Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> observableEmitter) throws Exception {
                for (int i = 0 ; i < 10; i++) {
                    final long l = i * 1L;
                    executor.execute(()->observableEmitter.onNext(l));
                }
            }
        });

        observable.subscribe(consumer1);
        observable.subscribe(consumer2);

        ((ExecutorService) executor).shutdown();
    }
}
