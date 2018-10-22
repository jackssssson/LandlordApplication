package com.daredevil.landlordcommunication.repositories;

import com.daredevil.landlordcommunication.http.HttpUserRequester;
import com.daredevil.landlordcommunication.parser.JsonParserContract;

import java.io.IOException;
import java.util.List;

public class PersonalUserHttpRepository<T> implements UserRepository<T> {
    private final HttpUserRequester mHttpRequester;
    private String mUrl;
    private JsonParserContract<T> mParser;

    public PersonalUserHttpRepository(HttpUserRequester requester, String url, JsonParserContract parser) {
        mHttpRequester = requester;
        mUrl = url;
        mParser = parser;
    }

    @Override
    public List<T> getAll() throws IOException {
        String jsonArr = mHttpRequester.get(mUrl + "/cars/getPersonal");
        List<T> list = mParser.fromJsonArray(jsonArr);
        return list;
    }

//    @Override
//    public void add(T item) throws IOException {
//        String addUrl = mUrl + "/cars/addToPersonal";
//        String body = mParser.toJson(item);
//        mHttpRequester.post(addUrl, body);
//
//    }
//
//    @Override
//    public void delete(int id) throws IOException {
//        String deleteUrl = mUrl + "/cars/deleteFromPersonal/" + id;
//        mHttpRequester.delete(deleteUrl);
//    }
//
//    @Override
//    public T getById(int id) throws IOException {
//        String jsonObj = mHttpRequester.get(mUrl + "/cars/getPersonal/" + id);
//        T obj = mParser.fromJson(jsonObj);
//        return obj;
//    }
}
