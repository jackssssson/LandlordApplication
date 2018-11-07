package com.daredevil.landlordcommunication.views.tenant;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.servieces.UserService;

import java.io.IOException;

import javax.inject.Inject;

public class TenantLogInPresenter implements Presenter {

    private View mView;
    private UserDTO mUserDTO;

    @Inject
    UserService mService;

    @Inject
    AsyncRunner mAsyncRunner;

    @Inject
    TenantLogInPresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void loadUser() {
        float sum = 0;
        for (Estates e : mUserDTO.getEstates()){
            sum += e.getPrice();
        }

        mView.showUserInfo(mUserDTO.getUserName(), mUserDTO.getUserEmail(),
                mUserDTO.getUserRating(), sum);
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
    }}
