package com.daredevil.landlordcommunication.views.chat;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.Messages;
import com.daredevil.landlordcommunication.servieces.UserService;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class ChatPresenter implements Presenter {

    private View mView;
    private int senderId;
    private int recipientId;
    private boolean isStopped;

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
    public void getMessages(int senderId, int recipientId) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        mAsyncRunner.runInBackground(() -> {
            try {

                if (mService.checkForMessages(senderId, recipientId)) {
                    List<Messages> messages = mService.getMessages(senderId, recipientId);
                    mView.showAdapter(messages);
                }
                mView.showAdapter(null);
                mView.hideLoading();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void refreshMessages() {
        new Thread(() -> {
            while (!isStopped) {
                try {
                    if (mService.checkForNewMessages(senderId, recipientId)) {
                        mView.showNewElement(mService.getNewMessages(senderId, recipientId));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void stopThread() {
        isStopped = true;
    }

    @Override
    public void sendMessage(String message, int senderId, int recipientId) {
        new Thread(() -> {
            try {
                Messages myMessage = mService.sendMessage(message, senderId, recipientId);
                mView.showSendMessage(myMessage);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
