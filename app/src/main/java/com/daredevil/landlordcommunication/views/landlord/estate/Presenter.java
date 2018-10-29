package com.daredevil.landlordcommunication.views.landlord.estate;

import com.daredevil.landlordcommunication.models.Estates;

public interface Presenter {
    void setView(View view);

    void createEstate(Estates estates, String name);
}
