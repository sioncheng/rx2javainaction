package com.github.sioncheng.rxj2.p4;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

public class Group {

    public static void main(String[] args) {
        Observable.range(1, 10)
                .groupBy(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) {
                        if (integer % 2 == 0) {
                            return "even";
                        } else {
                            return "odd";
                        }
                    }
                })
                .subscribe(new Consumer<GroupedObservable<String, Integer>>() {
                    String even = "";
                    String odd = "";
                    @Override
                    public void accept(GroupedObservable<String, Integer> stringIntegerGroupedObservable) throws Exception {
                        System.out.println(stringIntegerGroupedObservable.getKey());
                        if ("even".equals(stringIntegerGroupedObservable.getKey()) && even.equals("")) {
                            stringIntegerGroupedObservable.subscribe(new Consumer<Integer>() {
                                @Override
                                public void accept(Integer integer) throws Exception {
                                    System.out.println("event " + integer);
                                }
                            });
                        }

                        if ("odd".equals(stringIntegerGroupedObservable.getKey()) && odd.equals("")) {
                            stringIntegerGroupedObservable.subscribe(new Consumer<Integer>() {
                                @Override
                                public void accept(Integer integer) throws Exception {
                                    System.out.println("odd " + integer);
                                }
                            });
                        }
                    }
                });
    }
}
