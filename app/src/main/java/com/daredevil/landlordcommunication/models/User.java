package com.daredevil.landlordcommunication.models;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {
    public User() {
    }
    private int userid;
    private String userEmail;
    private String userName;
    private String userPassword;
    private BankAccount bankAccount;
    private Estates estate;

    public User(int userid, String userEmail, String userName,
                String userPassword, BankAccount bankAccount, Estates estate) {
        this.userid = userid;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
        this.bankAccount = bankAccount;
        this.estate = estate;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Estates getEstate() {
        return estate;
    }

    public void setEstate(Estates estate) {
        this.estate = estate;
    }

}
