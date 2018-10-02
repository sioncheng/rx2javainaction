package com.github.sioncheng.rxj2.p9;

import io.reactivex.*;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FlowableSubscribe {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss SSS");

    public static void main(String[] args) throws Exception {

        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> flowableEmitter) throws Exception {
                println("emit 1");
                flowableEmitter.onNext(1);
                println("emit 2");
                flowableEmitter.onNext(2);
                println("emit 3");
                flowableEmitter.onNext(3);
            }
        }, BackpressureStrategy.DROP)
                //.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Integer>() {
                    Subscription subscription1;
                    int n = 0;
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        println("first request");
                        subscription1 = subscription;
                        //subscription.request(1);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        println("onNext " + integer);

                        if (n++ < 2) {
                            println("continue request");
                            subscription1.request(1);
                        }

                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        TimeUnit.SECONDS.sleep(3);
    }

    private static void println(String message) {
        System.out.println(simpleDateFormat.format(new Date()) + " : "
                + Thread.currentThread().getName() + " : " + message);
    }
}
