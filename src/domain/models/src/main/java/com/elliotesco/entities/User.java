package com.elliotesco.entities;

import java.util.List;

public class User {
    private String id;
    private String name;
    private String email;
    private String address;
    private List<Account> accounts;

    public User() {
    }

    public User(String id, String name, String email, String address, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.accounts = accounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
