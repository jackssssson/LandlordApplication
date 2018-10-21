package com.daredevil.landlordcommunication.parser;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;

public class GsonParser<T> implements JsonParserContract<T> {
    private final Class<T> mKlass;
    private final Class<T[]> mArrKlass;
    private final Gson gson;

    public GsonParser(Class<T> mKlass, Class<T[]> mArrKlass) {
        this.mKlass = mKlass;
        this.mArrKlass = mArrKlass;
        this.gson = new Gson();
    }

    @Override
    public List<T> fromJsonArray(String jsonString) {
        T[] arr = gson.fromJson(jsonString, mArrKlass);
        return Arrays.asList(arr);
    }

    @Override
    public T fromJson(String jsonString) {
        return gson.fromJson(jsonString, mKlass);
    }

    @Override
    public String toJson(T obj) {
        return gson.toJson(obj);
    }
}
