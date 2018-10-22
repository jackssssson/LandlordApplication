package com.daredevil.landlordcommunication.models;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {
    public User() {
    }

    private int id;
    private String name;
    private String password;
    private String email;
    private Set<UserRating> user_ratings;
    private UserType user_types;
    private Estates estates;
    private BankAccount bank_account;
    private Set<Messages> recipientMessage;
    private Set<Messages> senderMessage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserRating> getUser_ratings() {
        return user_ratings;
    }

    public void setUser_ratings(Set<UserRating> user_ratings) {
        this.user_ratings = user_ratings;
    }

    public UserType getUser_types() {
        return user_types;
    }

    public void setUser_types(UserType user_types) {
        this.user_types = user_types;
    }

    public Estates getEstates() {
        return estates;
    }

    public void setEstates(Estates estates) {
        this.estates = estates;
    }

    public BankAccount getBank_account() {
        return bank_account;
    }

    public void setBank_account(BankAccount bank_account) {
        this.bank_account = bank_account;
    }

    public Set<Messages> getRecipientMessage() {
        return recipientMessage;
    }

    public void setRecipientMessage(Set<Messages> recipientMessage) {
        this.recipientMessage = recipientMessage;
    }

    public Set<Messages> getSenderMessage() {
        return senderMessage;
    }

    public void setSenderMessage(Set<Messages> senderMessage) {
        this.senderMessage = senderMessage;
    }
}
