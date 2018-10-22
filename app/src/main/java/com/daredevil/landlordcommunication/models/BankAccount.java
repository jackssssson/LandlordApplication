package com.daredevil.landlordcommunication.models;

import java.io.Serializable;
import java.util.List;

public class BankAccount implements Serializable {
    public BankAccount() {
    }

    private int id;
    private float balance;
    private List<Transactions> transactions;
    private User users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
