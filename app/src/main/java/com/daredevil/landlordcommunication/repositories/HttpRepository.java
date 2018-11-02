package com.daredevil.landlordcommunication.repositories;

import com.daredevil.landlordcommunication.constants.Constants;
import com.daredevil.landlordcommunication.http.HttpRequester;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.Messages;
import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.parser.GsonParser;
import com.daredevil.landlordcommunication.parser.JsonParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
        String url = Constants.IS_USER_FREE;

        String requestBody = mJsonParserDTO.toJson(user);
        String responseBody = mHttpRequester.postUser(url, requestBody);

        if (responseBody.equals("User is free")) {
            String body;
            if (type.equals("Landlord")) {
                body = mHttpRequester.postUser(Constants.POST_LANDLORD, requestBody);
            } else {
                body = mHttpRequester.postUser(Constants.POST_TENANT, requestBody);
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
        String url = Constants.IS_LOGIN_CORRECT + "/" + userName + "/" + password;

        String getUser = mHttpRequester.getUserLogIn(url);
        if (getUser.equals("true")) {
            String json = mHttpRequester.getUser(Constants.GET_BY_USER_NAME_AND_PASSWORD
                    + "/" + userName + "/" + password);

            return mJsonParserDTO.fromJson(json);
        } else {
            return new UserDTO();
        }
    }

    @Override
    public String createEstate(Estates estates, String name) throws IOException {
        String url = Constants.CREATE_ESTATE + name;
        JsonParser<Estates> jsonEstate = new GsonParser<>(Estates.class);

        String requestBody = jsonEstate.toJson(estates);

        return mHttpRequester.postUser(url, requestBody);
    }

    @Override
    public Estates getEstates() throws IOException {
        String url = "";
        String estate = mHttpRequester.getUser(url);
        JsonParser<Estates> jsonEstate = new GsonParser<>(Estates.class);

        return jsonEstate.fromJson(estate);
    }

    @Override
    public UserDTO postIdEstate(int id) throws IOException {
        String url = Constants.GET_TENANT + id;
        String json = mHttpRequester.getUser(url);
        return mJsonParserDTO.fromJson(json);
    }

    @Override
    public String setDueDate(String dueDate, int id) throws IOException {
        String url = Constants.SET_DUE_DATE + dueDate + "/" + id;
        return mHttpRequester.postText(url);
    }

    @Override
    public String rateUser(int rating, String name, String userName) throws IOException {
        String url = Constants.RATING_USER + rating + "/" + name + "/" + userName;
        return mHttpRequester.postText(url);
    }

    @Override
    public String setOwed(String price, int id) throws IOException {
        String url = Constants.SET_OWED + "/" + id + "/" + price;
        return mHttpRequester.postText(url);
    }

    @Override
    public List<Estates> getUnoccupiedEstates() throws IOException {
        String url = Constants.GET_UNOCCUPIED_ESTATE;
        String json = mHttpRequester.getUser(url);
        JsonParser<Estates[]> jsonEstate = new GsonParser<>(Estates[].class);
        return Arrays.asList(jsonEstate.fromJson(json));
    }

    @Override
    public UserDTO postIdPerson(int id) throws IOException {
        String url = Constants.GET_LANDLORD + id;
        String json = mHttpRequester.getUser(url);
        return mJsonParserDTO.fromJson(json);
    }

    @Override
    public String rentEstate(String userId, String estateId) throws IOException {
        String url = Constants.RENT_ESTATE + userId + "/" + estateId;
        return mHttpRequester.postText(url);
    }

    @Override
    public UserDTO getUserById(int id) throws IOException {
        String url = Constants.GET_USER_BY_ID + id;
        String json = mHttpRequester.getUser(url);
        return mJsonParserDTO.fromJson(json);
    }

    @Override
    public List<Messages> getMessages(int tenantId, int landlordId) throws IOException {
        String url = Constants.GET_MESSAGES;
        String json = mHttpRequester.getUser(url);
        JsonParser<Messages[]> jsonEstate = new GsonParser<>(Messages[].class);
        return Arrays.asList(jsonEstate.fromJson(json));
    }
}
