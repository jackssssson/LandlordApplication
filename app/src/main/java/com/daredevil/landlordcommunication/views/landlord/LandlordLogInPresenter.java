package com.daredevil.landlordcommunication.views.landlord;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.servieces.UserService;

import java.io.IOException;

import javax.inject.Inject;

public class LandlordLogInPresenter implements Presenter {
    private UserDTO mUserDTO;
    private View mView;

    @Inject
    UserService mService;

    @Inject
    AsyncRunner mAsyncRunner;

    @Inject
    LandlordLogInPresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void loadUser() {
        mView.showUserInfo(mUserDTO.getUserName(), mUserDTO.getUserEmail(),
                mUserDTO.getUserRating());
    }

    @Override
    public void setUser(UserDTO user) {
        this.mUserDTO = user;
    }


    @Override
    public void refreshUserDto(int id) {
        mAsyncRunner.runInBackground(() -> {
            try {
                mView.setUserDTO(mService.getUserById(id));
                mView.showEstateAdapter();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
