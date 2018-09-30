package com.github.sioncheng.rxj2.p4;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Map {

    public static void main(String[] args) {
        Observable.just("hello")
                .map(x -> x.toUpperCase())
                .subscribe(System.out::println);


        List<User.Address> addressList1 = new ArrayList<>();
        addressList1.add(new User.Address("street1", "city1"));
        addressList1.add(new User.Address("street2", "city2"));
        addressList1.add(new User.Address("street3", "city3"));

        User user = new User("user1", addressList1);

        Observable.just(user)
                .map(new Function<User, List<User.Address>>() {
                    @Override
                    public List<User.Address> apply(User user) {
                        List<User.Address> addresses = new ArrayList<>();
                        Iterator<User.Address> stringIterator = user.getAddress();
                        while (stringIterator.hasNext()) {
                            addresses.add(stringIterator.next());
                        }

                        return addresses;
                    }
                }).subscribe(new Consumer<List<User.Address>>() {
            @Override
            public void accept(List<User.Address> addresses) throws Exception {
                addresses.stream().forEach(System.out::println);
            }
        });

        Observable.just(user)
                .flatMap(new Function<User, ObservableSource<User.Address>>() {
                    @Override
                    public ObservableSource<User.Address> apply(User user) throws Exception {
                        List<User.Address> addresses = new ArrayList<>();
                        Iterator<User.Address> stringIterator = user.getAddress();
                        while (stringIterator.hasNext()) {
                            addresses.add(stringIterator.next());
                        }

                        return Observable.fromIterable(addresses);
                    }
                })
                .subscribe(System.out::println);



    }
}
