package com.daredevil.landlordcommunication.views.CreateUser;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.http.HttpRequester;
import com.daredevil.landlordcommunication.http.OkHttpHttpRequester;
import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.parser.GsonParser;
import com.daredevil.landlordcommunication.parser.JsonParser;
import com.daredevil.landlordcommunication.repositories.HttpRepository;
import com.daredevil.landlordcommunication.repositories.Repository;

import java.io.IOException;

public class CreateUserPresenter implements Presenter {
    private View mView;
    private Repository<UserDTO> mCreateUserDTORepository;
    private HttpRequester mHttpRequester;
    private JsonParser<User> mJsonParser;

    public CreateUserPresenter(){
        mJsonParser = new GsonParser(User.class);
        mHttpRequester = new OkHttpHttpRequester();
        mCreateUserDTORepository = new HttpRepository(mHttpRequester, mJsonParser);
        mCreateUserDTORepository = new HttpRepository(mHttpRequester, mJsonParser);
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void createUserDTO(UserDTO user) throws IOException {

        AsyncRunner.runInBackGround(() -> {
            try {
                mCreateUserDTORepository.add(user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
