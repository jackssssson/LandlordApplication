package com.daredevil.landlordcommunication.parser;

public interface JsonParser<T> {
    T fromJson(String jsonString);
    String toJson(T obj);
}
