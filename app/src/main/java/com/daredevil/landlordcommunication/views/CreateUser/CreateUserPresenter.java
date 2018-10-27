package com.daredevil.landlordcommunication.views.CreateUser;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.http.HttpRequester;
import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.parser.JsonParser;
import com.daredevil.landlordcommunication.repositories.Repository;

import java.io.IOException;

import javax.inject.Inject;

public class CreateUserPresenter implements Presenter {
    private View mView;

    @Inject
    Repository<UserDTO> mCreateUserDTORepository;

    @Inject
    HttpRequester mHttpRequester;

    @Inject
    JsonParser<User> mJsonParser;

    @Inject
    AsyncRunner mAsyncRunner;

    @Inject
    public CreateUserPresenter(){
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void createUserDTO(UserDTO user) throws IOException {
        mAsyncRunner.runInBackground(() -> {
            try {
                mCreateUserDTORepository.add(user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
