package com.daredevil.landlordcommunication.parser;

import com.daredevil.landlordcommunication.models.Estates;

import java.util.List;

public interface JsonParser<T> {
    T fromJson(String jsonString);
    String toJson(T obj);
    List<Estates> parseEstate(String jsonString);
}
