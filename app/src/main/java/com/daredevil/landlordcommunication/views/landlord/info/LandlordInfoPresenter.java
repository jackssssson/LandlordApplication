package com.daredevil.landlordcommunication.views.landlord.info;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.repositories.Repository;

import java.io.IOException;

import javax.inject.Inject;

public class LandlordInfoPresenter implements Presenter {

    private View mView;
    private UserDTO userDTO;

    @Inject
    Repository mRepository;

    @Inject
    AsyncRunner asyncRunner;

    @Inject
    LandlordInfoPresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void postIdEstate(int id, Estates estates) {
        asyncRunner.runInBackground(() -> {

            if (estates.isOccupied()){
                try {
                    userDTO = mRepository.postIdEstate(id);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mView.showUserDTO(userDTO);
            }
        });
    }

    @Override
    public void setDueDate(String dueDate, int id) {
        asyncRunner.runInBackground(() -> {
            try {
                String result = mRepository.setDueDate(dueDate, id);
                mView.showMessage(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void rateUser(int rating, String name) {
        asyncRunner.runInBackground(() -> {
            try {
               String result = mRepository.rateUser(rating, userDTO.getUserName(), name);
               mView.showMessage(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void setOwed(String price, int id) {
        asyncRunner.runInBackground(() -> {
            try {
                String result = mRepository.setOwed(price, id);
                mView.showMessage(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
