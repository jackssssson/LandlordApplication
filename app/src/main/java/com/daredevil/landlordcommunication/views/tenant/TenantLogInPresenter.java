package com.daredevil.landlordcommunication.views.tenant;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.repositories.Repository;

import java.io.IOException;

import javax.inject.Inject;

public class TenantLogInPresenter implements Presenter {

    private View mView;
    private UserDTO mUserDTO;

    @Inject
    Repository mRepository;

    @Inject
    AsyncRunner asyncRunner;

    @Inject
    TenantLogInPresenter() {
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
        asyncRunner.runInBackground(() -> {
            try {
                mView.setUserDTO(mRepository.getUserById(id));
                mView.showEstateAdapter();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }}
