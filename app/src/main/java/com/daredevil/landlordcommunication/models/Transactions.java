package com.daredevil.landlordcommunication.models;

import java.io.Serializable;
import java.util.Date;

public class Transactions implements Serializable {
    public Transactions() {
    }

    private int id;
    private float amount;
    private Date timestamp;
    private BankAccount bank_account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public BankAccount getBank_account() {
        return bank_account;
    }

    public void setBank_account(BankAccount bank_account) {
        this.bank_account = bank_account;
    }
}
