package com.daredevil.landlordcommunication.repositories;

import com.daredevil.landlordcommunication.constants.Constants;
import com.daredevil.landlordcommunication.http.HttpRequester;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.parser.GsonParser;
import com.daredevil.landlordcommunication.parser.JsonParser;

import java.io.IOException;

import javax.inject.Inject;

public class HttpRepository implements Repository {
    @Inject
    HttpRequester mHttpRequester;

    @Inject
    JsonParser<User> mJsonParserUser;

    @Inject
    JsonParser<UserDTO> mJsonParserDTO;

    @Inject
    public HttpRepository(HttpRequester mHttpRequester, JsonParser<User> mJsonParserUser,
                          JsonParser<UserDTO> mJsonParserDTO) {
       this.mHttpRequester = mHttpRequester;
       this.mJsonParserDTO = mJsonParserDTO;
       this.mJsonParserUser = mJsonParserUser;
    }

//    @Override
//    public T add(T item) throws IOException {
//        String requestBody = mJsonParser.toJson(item);
//        String responseBody = mHttpRequester.postUser(Constants.postLandlord, requestBody);
//        return mJsonParser.fromJson(responseBody);
//
//    }

    @Override
    public String addUser(UserDTO user, String type) throws IOException {
        String url = Constants.isUserFree;

        String requestBody = mJsonParserDTO.toJson(user);
        String responseBody = mHttpRequester.postUser(url, requestBody);

        if (responseBody.equals("User is free")){
            String body;
            if (type.equals("Landlord")){
                 body = mHttpRequester.postUser(Constants.postLandlord, requestBody);
            } else {
                body = mHttpRequester.postUser(Constants.postTenant, requestBody);
            }

            return body;
        } else {
            return responseBody;
        }
    }

//    @Override
//    public T getById(int id) throws IOException {
//        String url = Constants.getUser;
//        String json = mHttpRequester.getUser(url);
//        return mJsonParser.fromJson(json);
//
//    }

    @Override
    public UserDTO getByUserNameAndPassword(String userName, String password) throws IOException {
        String url = Constants.isLoginCorrect + "/" + userName + "/" + password;

        String getUser = mHttpRequester.getUserLogIn(url);
        if (getUser.equals("true")) {
            String json = mHttpRequester.getUser(Constants.getByUserNameAndPassword
                    + "/" + userName + "/" + password);

            return mJsonParserDTO.fromJson(json);
        } else {
            return new UserDTO();
        }
    }

    @Override
    public String createEstate(Estates estates, String name) throws IOException {
        String url = Constants.createEstateUrl + name;
        JsonParser<Estates> jsonEstate = new GsonParser<>(Estates.class);

        String requestBody = jsonEstate.toJson(estates);

        return mHttpRequester.postUser(url, requestBody);
    }
}
