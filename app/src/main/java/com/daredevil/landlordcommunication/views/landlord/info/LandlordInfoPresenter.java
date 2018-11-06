package com.daredevil.landlordcommunication.views.landlord.info;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.Messages;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.servieces.UserService;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class LandlordInfoPresenter implements Presenter {

    private View mView;
    private UserDTO userDTO;
    private int userId;

    @Inject
    UserService mService;

    @Inject
    AsyncRunner mAsyncRunner;

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
        mAsyncRunner.runInBackground(() -> {

            if (estates.isOccupied()) {
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
        mAsyncRunner.runInBackground(() -> {
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
    public void setOwed(String price, int id) {
        mAsyncRunner.runInBackground(() -> {
            try {
                String result = mService.setOwed(price, id);
                mView.showMessage(result);
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
    public void getMessagesForAdapter(int id) {
        mAsyncRunner.runInBackground(() -> {
            try {
                String result = mService.checkForEstateMessage(id);

                if (result.equals("false")) {
                    return;
                }

                List<Messages> messages = mService.getMessagesForAdapter(id);
                mView.showMessagesInAdapter(messages);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void refreshInfo() {
        try {
            userDTO = mService.postIdEstate(userId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mView.showUserDTO(userDTO);
    }
}
