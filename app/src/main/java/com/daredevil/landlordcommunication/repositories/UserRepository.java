package com.daredevil.landlordcommunication.repositories;

import java.io.IOException;
import java.util.List;

public interface UserRepository<T> {
    List<T> getAll() throws IOException;

//    void add(T item) throws IOException;
//
//    void delete(int id) throws IOException;
//
//    T getById(int id) throws IOException;
}
