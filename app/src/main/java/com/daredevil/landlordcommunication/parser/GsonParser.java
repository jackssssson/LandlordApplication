package com.daredevil.landlordcommunication.parser;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;

public class GsonParser<T> implements JsonParser<T> {
    private final Class<T> mTClass;
    private final Class<T[]> mArrayClass;
    private final Gson gson;

    public GsonParser(Class<T> tClass, Class<T[]> arrayClass) {
        this.mTClass = tClass;
        this.mArrayClass = arrayClass;
        this.gson = new Gson();
    }

    @Override
    public List<T> fromJsonArray(String jsonString) {
        T[] arr = gson.fromJson(jsonString, mArrayClass);
        return Arrays.asList(arr);
    }

    @Override
    public T fromJson(String jsonString) {
        return gson.fromJson(jsonString, mTClass);
    }

    @Override
    public String toJson(T obj) {
        return gson.toJson(obj);
    }
}
