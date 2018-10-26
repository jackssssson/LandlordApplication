package com.daredevil.landlordcommunication.views.main;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.constants.Constants;
import com.daredevil.landlordcommunication.http.HttpRequester;
import com.daredevil.landlordcommunication.http.OkHttpHttpRequester;
import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.parser.GsonParser;
import com.daredevil.landlordcommunication.parser.JsonParser;
import com.daredevil.landlordcommunication.repositories.HttpRepository;
import com.daredevil.landlordcommunication.repositories.Repository;

import java.io.IOException;

public class InitialScreenPresenter implements Presenter{

    private View mView;
    private Repository<User> mUserRepository;
    private Repository<UserDTO> mCreateUserDTORepository;
    private HttpRequester mHttpRequester;
    private JsonParser<User> mJsonParser;

    public InitialScreenPresenter() {

        mJsonParser = new GsonParser(User.class);
        mHttpRequester = new OkHttpHttpRequester();
        mUserRepository = new HttpRepository(mHttpRequester, mJsonParser);
        mCreateUserDTORepository = new HttpRepository(mHttpRequester, mJsonParser);
        mCreateUserDTORepository = new HttpRepository(mHttpRequester, mJsonParser);
    }

    @Override
    public void setView(View view) {
        mView = view;
    }

    @Override
    public void logInUser(String userName, String password) {
        AsyncRunner.runInBackGround(() ->{
            try {
               User a = mUserRepository.getByUserNameAndPassword(userName, password);



            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
