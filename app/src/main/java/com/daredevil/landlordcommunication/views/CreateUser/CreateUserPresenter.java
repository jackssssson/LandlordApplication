package com.daredevil.landlordcommunication.views.CreateUser;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.http.HttpRequester;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.repositories.Repository;

import java.io.IOException;

import javax.inject.Inject;

public class CreateUserPresenter implements Presenter {
    private View mView;

    @Inject
    Repository mCreateUserDTORepository;

    @Inject
    HttpRequester mHttpRequester;

    @Inject
    AsyncRunner asyncRunner;

    @Inject
    CreateUserPresenter(){
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void createUserDTO(UserDTO user, String type) throws IOException {
        asyncRunner.runInBackground(() -> {
            try {
                if (type.equals("")){
                    mView.typeWarning();
                    return;
                }

               String userDTO = mCreateUserDTORepository.addUser(user, type);

               mView.createUserDTO(userDTO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
