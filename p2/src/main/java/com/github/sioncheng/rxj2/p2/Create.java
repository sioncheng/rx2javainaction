package com.github.sioncheng.rxj2.p2;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Create {

    static class DisposableHolder {

        private volatile Disposable sub;

        public Disposable getSub() {
            System.out.println("getSub " + this);
            return sub;
        }

        public void setSub(Disposable sub) {
            System.out.println("setSub " + this);
            this.sub = sub;
        }

    }

    static volatile DisposableHolder dh = new DisposableHolder();

    public static void main(String[] args) {
        Observable<Integer> integerObservable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for (int i = 0 ; i < 10; i++) {
                            if (!observableEmitter.isDisposed()) {
                                try {
                                    TimeUnit.MILLISECONDS.sleep(400);
                                } catch (InterruptedException ie) {
                                    ie.printStackTrace();
                                }
                                observableEmitter.onNext(i);
                            }
                        }
                    }
                });

                t.start();
            }
        });



        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                if (dh.getSub() != null) {
                    dh.getSub().dispose();
                    System.out.println(dh.getSub().isDisposed());
                } else {
                    System.out.println("null");
                }
            }
        });
        t.start();

        Disposable sub = integerObservable.subscribe(x -> {
            System.out.println(x);

        });

        dh.setSub(sub);
    }
}
