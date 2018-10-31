package com.daredevil.landlordcommunication.views.tenant.estate;

import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.dto.UserDTO;

public interface Presenter {
    void setView(View view);

    void loadInfo();

    void setEstate(Estates estate);

    void setUserId(int id);

    void rateEstate();
}
