package com.daredevil.landlordcommunication.parser;

import java.util.List;

public interface JsonParserContract<T> {
    List<T> fromJsonArray(String jsonString);
    T fromJson(String jsonString);
    String toJson(T obj);
}
