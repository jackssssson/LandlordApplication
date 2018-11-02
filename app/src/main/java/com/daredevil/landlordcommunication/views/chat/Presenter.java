package com.daredevil.landlordcommunication.views.chat;

public interface Presenter {
    void setView(View view);

    void getMessages(int tenantId, int landlordId);
}
