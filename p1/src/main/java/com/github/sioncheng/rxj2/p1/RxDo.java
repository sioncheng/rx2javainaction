package com.github.sioncheng.rxj2.p1;

import io.reactivex.Observable;

public class RxDo {

    public static void main(String[] args) {
        Observable.just("hello")
                .doOnNext(x -> System.out.println("doOnNext " + x))
                .doAfterNext(x -> System.out.println("doAfterNext " + x))
                .doOnSubscribe(x -> System.out.println("doOnSubscribe " + x))
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doOnLifecycle(x -> System.out.println("doOnLifeCycle 1"), ()-> System.out.println("doOnLifeCycle 2"))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnDispose(() -> System.out.println("doOnDispose"))
                .subscribe(System.out::println);
    }
}
