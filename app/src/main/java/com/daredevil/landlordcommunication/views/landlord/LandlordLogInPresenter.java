package com.daredevil.landlordcommunication.views.landlord;

import com.daredevil.landlordcommunication.models.dto.UserDTO;

import javax.inject.Inject;

public class LandlordLogInPresenter implements Presenter {
    private UserDTO mUserDTO;
    private View mView;

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
}
