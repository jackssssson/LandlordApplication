package com.daredevil.landlordcommunication.views.chat;

public interface Presenter {
    void setView(View view);

    void getMessages(int senderId, int recipientId);

    void refreshMessages();

    void stopThread();

    void sendMessage(String message, int senderId, int recipientId);
}
