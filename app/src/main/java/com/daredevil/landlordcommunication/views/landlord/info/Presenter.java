package com.daredevil.landlordcommunication.views.landlord.info;

import com.daredevil.landlordcommunication.models.Estates;

public interface Presenter {
    void setView(View view);

    void postIdEstate(int id, Estates estates);

    void setDueDate(String dueDate, int id);

    void rateUser(int rating, String name);

    void setOwed(String price, int id);
}
