package com.daredevil.landlordcommunication.views.tenant.estate;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.repositories.Repository;

import java.io.IOException;

import javax.inject.Inject;

public class TenantEstatePresenter implements Presenter {

    private View mView;
    private int userId;
    private Estates estates;
    private UserDTO userDTO;

    @Inject
    Repository mRepository;

    @Inject
    AsyncRunner asyncRunner;

    @Inject
    TenantEstatePresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void loadInfo() {
        asyncRunner.runInBackground(() -> {
            try {
                userDTO = mRepository.postIdPerson(estates.getEstateid());
                mView.showUserInfo(userDTO.getUserName(), userDTO.getUserEmail(),
                        String.valueOf(userDTO.getUserRating()), String.valueOf(estates.getPrice()),
                        estates.getAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void setEstate(Estates estate) {
        this.estates = estate;
    }

    @Override
    public void setUserId(int id) {
        this.userId = id;
    }

    @Override
    public void rateEstate() {
        asyncRunner.runInBackground(() -> {
            try {
                mRepository.rentEstate(String.valueOf(userId),
                        String.valueOf(estates.getEstateid()));

                mView.showEstateRented();
            } catch (IOException e) {
                mView.showErrorMessage("Can`t rent");
                e.printStackTrace();
            }
        });
    }
}
