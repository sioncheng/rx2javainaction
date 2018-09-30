package com.github.sioncheng.rxj2.p4;

import java.util.Iterator;
import java.util.List;

public class User {

    public User(String username, List<Address> address) {
        this.username = username;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public Iterator<Address> getAddress() {
        return this.address.iterator();
    }

    private String username;
    private List<Address> address;


    public static class Address {
        private String street;
        private String city;

        public Address(String street, String city) {
            this.street = street;
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return this.street + "," + this.city;
        }
    }
}
