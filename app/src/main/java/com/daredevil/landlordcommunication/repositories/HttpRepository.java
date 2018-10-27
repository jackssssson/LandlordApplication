package com.daredevil.landlordcommunication.repositories;

import com.daredevil.landlordcommunication.constants.Constants;
import com.daredevil.landlordcommunication.http.HttpRequester;
import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.parser.JsonParser;

import java.io.IOException;

import javax.inject.Inject;

public class HttpRepository<T> implements Repository<T> {
    private final HttpRequester mHttpRequester;
    private final JsonParser<T> mJsonParser;

    @Inject
    JsonParser<User> jsonParser;

    @Inject
    public HttpRepository(HttpRequester httpRequester, JsonParser<T> jsonParser) {
        this.mHttpRequester = httpRequester;
        this.mJsonParser = jsonParser;
    }

    @Override
    public T add(T item) throws IOException {
        String requestBody = mJsonParser.toJson(item);
        String responseBody = mHttpRequester.postUser(Constants.postLandlord, requestBody);
        return mJsonParser.fromJson(responseBody);

    }

    @Override
    public T getById(int id) throws IOException {
        String url = Constants.getUser;
        String json = mHttpRequester.getUser(url);
        return mJsonParser.fromJson(json);

    }

    @Override
    public User getByUserNameAndPassword(String userName, String password) throws IOException {
        String url = Constants.isLoginCorrect + "/" + userName + "/" + password;

        String getUser = mHttpRequester.getUserLogIn(url);
        if (getUser.equals("true")) {
            String json = mHttpRequester.getUser(Constants.getByUserNameAndPassword
                    + "/" + userName + "/" + password);

            return jsonParser.fromJson(json);
        } else {
            return new User();
        }
    }
}
