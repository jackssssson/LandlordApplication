package com.daredevil.landlordcommunication.views.main;


import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.http.HttpRequester;
import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.parser.JsonParser;
import com.daredevil.landlordcommunication.servieces.UserService;

import java.io.IOException;

import javax.inject.Inject;

public class InitialScreenPresenter implements Presenter{

    private View mView;

    @Inject
    UserService mService;

    @Inject
    HttpRequester mHttpRequester;

    @Inject
    JsonParser<User> mJsonParser;

    @Inject
    AsyncRunner mAsyncRunner;

    @Inject
    InitialScreenPresenter() {
    }

    @Override
    public void setView(View view) {
        mView = view;
    }

    @Override
    public void logInUser(String userName, String password) {
        mAsyncRunner.runInBackground(() -> {
            try {
                UserDTO user = mService.getByUserNameAndPassword(userName, password);

                mView.savePreference(userName, password);

                mView.logInUser(user);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void showNotification(String user_name) {
        mAsyncRunner.runInBackground(()->{
            try {
                String notification=mService.getNotification(user_name);
                mView.setNotification(notification);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
