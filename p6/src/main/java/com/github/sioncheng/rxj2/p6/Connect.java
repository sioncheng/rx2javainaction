package com.github.sioncheng.rxj2.p6;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Connect {

    public static void main(String[] args) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

        Observable<Long> obsLong = Observable.interval(1, TimeUnit.SECONDS).take(5);

        ConnectableObservable<Long> longConnectableObservable = obsLong.publish();

        longConnectableObservable.subscribe(l -> {
            System.out.println(simpleDateFormat.format(new Date()) + " " + l);
        });

        longConnectableObservable.delaySubscription(3, TimeUnit.SECONDS)
                .subscribe(l -> {
                   System.out.println(simpleDateFormat.format(new Date()) + " [" + l + "]");
                });

        //very important
        longConnectableObservable.connect();

        TimeUnit.SECONDS.sleep(6);
    }
}
