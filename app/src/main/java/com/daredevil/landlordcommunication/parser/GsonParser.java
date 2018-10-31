package com.daredevil.landlordcommunication.parser;

import com.daredevil.landlordcommunication.models.Estates;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

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

    @Override
    public List<Estates> parseEstate(String jsonString) {
        Type listType = new TypeToken<List<Estates>>() {}.getType();
        List<Estates> user = gson.fromJson(jsonString, listType);

        return user;
    }
}
