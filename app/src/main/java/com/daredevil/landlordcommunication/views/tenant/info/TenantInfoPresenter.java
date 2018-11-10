package com.daredevil.landlordcommunication.views.tenant.info;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.Messages;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.servieces.UserService;

import java.io.IOException;
import java.util.List;

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
                mView.hideLoading();
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

    @Override
    public void chatClicked() {
        mView.buttonChat(userDTO.getUserid());
    }

    @Override
    public void payRent(String value, int id) {
        mAsyncRunner.runInBackground(() -> {
            String result = null;
            try {

                if (value.equals("")){
                    result = "Please enter value";
                } else {
                    result = mService.payRent(value, id);
                    refreshRent(id);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            mView.showMessage(result);
        });
    }

    @Override
    public void refreshRent(int id) {
        mAsyncRunner.runInBackground(() -> {
            try {
                Estates estates = mService.refreshEstate(id);
                mView.showEstate(estates);
            } catch (IOException e) {
                e.printStackTrace();
            }


        });
    }

    @Override
    public void getMessagesForAdapter(int id) {
        mAsyncRunner.runInBackground(() -> {
            try {
                mView.showAdapterLoading();
                String result = mService.checkForEstateMessage(id);

                if (result.equals("false")) {
                    return;
                }

                List<Messages> messages = mService.getMessagesForAdapter(id);
                mView.showMessagesInAdapter(messages);
                mView.hideAdapterLoading();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void postEstateMessage(String spinnerMessage, int estateId, int userId) {
        mAsyncRunner.runInBackground(() -> {
            try {
                String result  = mService.postEstateMessage(spinnerMessage, estateId, userId);
                mView.showMessage(result);
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
