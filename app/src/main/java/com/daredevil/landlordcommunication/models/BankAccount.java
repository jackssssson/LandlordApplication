package com.daredevil.landlordcommunication.models;

import java.io.Serializable;
import java.util.List;

public class BankAccount implements Serializable {
    public BankAccount() {
    }

    private int bankAccountID;
    private float balance;


    public int getBankAccountID() {
        return bankAccountID;
    }

    public void setBankAccountID(int bankAccountID) {
        this.bankAccountID = bankAccountID;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public BankAccount(int bankAccountID, float balance) {
        this.bankAccountID = bankAccountID;
        this.balance = balance;
    }
}
