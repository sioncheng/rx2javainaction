package com.github.sioncheng.rxj2.p2;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.Arrays;
import java.util.List;

public class JustAndFrom {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");

        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                System.out.println(o);
            }
        };

        Observable.just(list).subscribe(consumer);

        Observable.fromIterable(list).subscribe(consumer);
    }
}
