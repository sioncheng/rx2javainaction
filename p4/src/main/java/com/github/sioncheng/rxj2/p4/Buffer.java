package com.github.sioncheng.rxj2.p4;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.List;

public class Buffer {

    public static void main(String[] args) {
        Observable.range(1, 10)
                .buffer(3)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        System.out.println(integers.size());

                    }
                });
    }
}
