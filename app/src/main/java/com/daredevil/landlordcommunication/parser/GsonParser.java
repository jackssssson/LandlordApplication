package com.daredevil.landlordcommunication.parser;

import com.google.gson.Gson;

import javax.inject.Inject;

public class GsonParser<T> implements JsonParser<T> {
    private final Class<T> mTClass;
    private final Gson gson;

    @Inject
    public GsonParser(Class<T> tClass) {
        this.mTClass = tClass;
        this.gson = new Gson();
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
