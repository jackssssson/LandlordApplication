package com.daredevil.landlordcommunication.models;

import java.io.Serializable;
import java.util.List;

public class UserType implements Serializable {
    public UserType() {
    }

    private int id;
    private String type;
    private List<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
