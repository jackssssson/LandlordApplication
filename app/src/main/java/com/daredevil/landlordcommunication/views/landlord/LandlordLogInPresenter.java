package com.daredevil.landlordcommunication.views.landlord;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.repositories.Repository;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class LandlordLogInPresenter implements Presenter {
    private UserDTO mUserDTO;
    private View mView;

    @Inject
    Repository mRepository;

    @Inject
    AsyncRunner asyncRunner;

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
    public void loadEstates() {
        asyncRunner.runInBackground(() -> {
            try {
                Estates estates = mRepository.getEstates();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void setEstates(List<Estates> estates) {

    }
}
