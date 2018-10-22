package com.daredevil.landlordcommunication.models;

import java.io.Serializable;

public class UserRating implements Serializable {
    public UserRating() {
    }

    private int id;
    private int rating;
    private User users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
