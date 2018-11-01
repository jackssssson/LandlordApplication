package com.daredevil.landlordcommunication.views.CreateUser;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.http.HttpRequester;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.servieces.UserService;

import java.io.IOException;

import javax.inject.Inject;

public class CreateUserPresenter implements Presenter {
    private View mView;

    @Inject
    UserService mService;

    @Inject
    HttpRequester mHttpRequester;

    @Inject
    AsyncRunner mAsyncRunner;

    @Inject
    CreateUserPresenter(){
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void createUserDTO(UserDTO user, String type) {
        mAsyncRunner.runInBackground(() -> {
            try {
                if (type.equals("")){
                    mView.typeWarning();
                    return;
                }

               String userDTO = mService.addUser(user, type);

               mView.createUserDTO(userDTO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
