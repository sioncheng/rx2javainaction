package com.github.sioncheng.rxj2.p1;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class HelloWorld {

    public static void main(String[] args) {
        Observable.just("hello")
                .subscribe(s -> System.out.println(s));

        Observable.just("world")
                .subscribe(System.out::println,
                        t->System.out.println(t.getMessage()),
                        ()->System.out.println("onComplete"),
                        d->System.out.println("onSubscribe " + d.toString()));

        Observable.just("!")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("onSubscribe " + disposable.toString());
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext " + s);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("OnComplete");
                    }
                });

        Observable<Integer> oi = Observable.just(100);
        Observer<Integer> os = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext " + integer);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

        oi.subscribe(os);
    }
}
