package com.daredevil.landlordcommunication.views.chat;

import com.daredevil.landlordcommunication.models.dto.MessageDTO;

public interface Presenter {
    void setView(View view);

    void getMessages(int senderId, int recipientId);

    void refreshMessages();

    void stopThread();

    void sendMessage(String message, int senderId, int recipientId);
}
