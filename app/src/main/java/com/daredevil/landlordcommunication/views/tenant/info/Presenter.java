package com.daredevil.landlordcommunication.views.tenant.info;

import com.daredevil.landlordcommunication.models.Estates;

public interface Presenter {
    void setView(View view);

    void postIdEstate(int id, Estates estates);

    void rateUser(int rating, String name);

    void chatClicked();

    void payRent(String value, int id);

    void refreshRent(int id);

    void getMessagesForAdapter(int id);

    void postEstateMessage(String spinnerMessage, int estateId, int userId);
}
