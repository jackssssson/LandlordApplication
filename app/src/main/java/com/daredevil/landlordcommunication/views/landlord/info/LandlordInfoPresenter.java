package com.daredevil.landlordcommunication.views.landlord.info;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.servieces.UserService;

import java.io.IOException;

import javax.inject.Inject;

public class LandlordInfoPresenter implements Presenter {

    private View mView;
    private UserDTO userDTO;
    private int userId;

    @Inject
    UserService mService;

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
        userId = id;
        asyncRunner.runInBackground(() -> {

            if (estates.isOccupied()){
                try {
                    userDTO = mService.postIdEstate(id);
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
                String result = mService.setDueDate(dueDate, id);
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
               String result = mService.rateUser(rating, userDTO.getUserName(), name);
               mView.showMessage(result);
               refreshInfo();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void setOwed(String price, int id) {
        asyncRunner.runInBackground(() -> {
            try {
                String result = mService.setOwed(price, id);
                mView.showMessage(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void refreshInfo(){
        try {
            userDTO = mService.postIdEstate(userId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mView.showUserDTO(userDTO);
    }
}
