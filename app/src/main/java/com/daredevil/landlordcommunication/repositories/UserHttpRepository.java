package com.daredevil.landlordcommunication.repositories;

import com.daredevil.landlordcommunication.http.HttpUserRequester;
import com.daredevil.landlordcommunication.parser.JsonParserContract;

import java.io.IOException;
import java.util.List;

public class UserHttpRepository<T> implements UserRepository<T> {
    private final HttpUserRequester mHttpRequester;
    private String mUrl;
    private JsonParserContract<T> mParser;

    public UserHttpRepository(HttpUserRequester httpRequester, String url, JsonParserContract parser) {
        this.mHttpRequester = httpRequester;
        this.mUrl = url;
        this.mParser = parser;
    }

    @Override
    public List<T> getAll() throws IOException {
        String jsonArr = mHttpRequester.get(mUrl + "/cars/getAll");
        List<T> list = mParser.fromJsonArray(jsonArr);
        return list;
    }

//    @Override
//    public void add(T item) throws IOException {
//        String addUrl = mUrl + "/cars/addToAll";
//        String body = mParser.toJson(item);
//        mHttpRequester.post(addUrl, body);
//
//    }
//
//    @Override
//    public void delete(int id) throws IOException {
//        String deleteUrl = mUrl + "/cars/deleteFromAll/" + id;
//        mHttpRequester.delete(deleteUrl);
//    }
//
//    @Override
//    public T getById(int id) throws IOException {
//        String jsonObj = mHttpRequester.get(mUrl + "/cars/getAll/" + id);
//        T obj = mParser.fromJson(jsonObj);
//        return obj;
//    }
}
