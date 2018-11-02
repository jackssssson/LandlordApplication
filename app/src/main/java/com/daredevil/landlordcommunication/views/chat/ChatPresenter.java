package com.daredevil.landlordcommunication.views.chat;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.Messages;
import com.daredevil.landlordcommunication.servieces.UserService;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class ChatPresenter implements Presenter {

    private View mView;

    @Inject
    UserService mService;

    @Inject
    AsyncRunner mAsyncRunner;

    @Inject
    ChatPresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void getMessages(int tenantId, int landlordId) {
        mAsyncRunner.runInBackground(() -> {
            try {
                List<Messages> messages = mService.getMessages(tenantId, landlordId);
                mView.showAdapter(messages);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
