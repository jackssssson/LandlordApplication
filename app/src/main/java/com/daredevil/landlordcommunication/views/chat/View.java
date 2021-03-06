package com.daredevil.landlordcommunication.views.chat;

import com.daredevil.landlordcommunication.models.Messages;

import java.util.List;

public interface View {
    void setPresenter(Presenter presenter);

    void showAdapter(List<Messages> messages);

    void showNewElement(List<Messages> messages);

    void showSendMessage(Messages message);

    void showLoading();

    void hideLoading();
}
