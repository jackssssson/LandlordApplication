package com.daredevil.landlordcommunication.repositories;

import com.daredevil.landlordcommunication.models.User;

import java.io.IOException;

public interface Repository<T> {
    T add(T item) throws IOException;

    T getById(int id) throws IOException;

    User getByUserNameAndPassword(String userName, String password) throws IOException;

}
