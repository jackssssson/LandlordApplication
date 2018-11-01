package com.daredevil.landlordcommunication.views.tenant.info;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.servieces.UserService;

import java.io.IOException;

import javax.inject.Inject;

public class TenantInfoPresenter implements Presenter{

    private View mView;
    private UserDTO userDTO;
    private int userId;

    @Inject
    UserService mService;

    @Inject
    AsyncRunner mAsyncRunner;

    @Inject
    TenantInfoPresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void postIdEstate(int id, Estates estates) {
        this.userId = id;
        mAsyncRunner.runInBackground(() -> {

            if (estates.isOccupied()){
                try {
                    userDTO = mService.postIdPerson(id);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mView.showUserDTO(userDTO);
            }
        });
    }

    @Override
    public void rateUser(int rating, String name) {
        mAsyncRunner.runInBackground(() -> {
            try {
                String result = mService.rateUser(rating, userDTO.getUserName(), name);
                mView.showMessage(result);
                refreshInfo();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void refreshInfo(){
        try {
            userDTO = mService.postIdPerson(userId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mView.showUserDTO(userDTO);
    }
}
