package com.daredevil.landlordcommunication.views.main;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.http.HttpRequester;
import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.parser.JsonParser;
import com.daredevil.landlordcommunication.repositories.Repository;

import java.io.IOException;

import javax.inject.Inject;

public class InitialScreenPresenter implements Presenter{

    private View mView;

    @Inject
    Repository<User> mUserRepository;

    @Inject
    Repository<UserDTO> mCreateUserDTORepository;

    @Inject
    HttpRequester mHttpRequester;

    @Inject
    JsonParser<User> mJsonParser;

    @Inject
    AsyncRunner mAsyncRunner;

    @Inject
    public InitialScreenPresenter() {
    }

    @Override
    public void setView(View view) {
        mView = view;
    }

    @Override
    public void logInUser(String userName, String password) {
        mAsyncRunner.runInBackground(() -> {
            try {
                User a = mUserRepository.getByUserNameAndPassword(userName, password);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}