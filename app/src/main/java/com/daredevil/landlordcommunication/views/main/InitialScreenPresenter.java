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
    Repository mUserRepository;

    @Inject
    HttpRequester mHttpRequester;

    @Inject
    JsonParser<User> mJsonParser;

    @Inject
    AsyncRunner asyncRunner;

    @Inject
    InitialScreenPresenter() {
    }

    @Override
    public void setView(View view) {
        mView = view;
    }

    @Override
    public void logInUser(String userName, String password) {
        asyncRunner.runInBackground(() -> {
            try {
                UserDTO user = mUserRepository.getByUserNameAndPassword(userName, password);

                mView.logInUser(user);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
