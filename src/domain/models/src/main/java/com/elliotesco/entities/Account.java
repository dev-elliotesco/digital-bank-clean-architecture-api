package com.elliotesco.entities;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String id;
    private String number;
    private String type;
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {
    }

    public Account(String id, String number, String type) {
        this.id = id;
        this.number = number;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
