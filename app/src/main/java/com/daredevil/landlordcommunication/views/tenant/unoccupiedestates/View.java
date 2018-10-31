package com.daredevil.landlordcommunication.views.tenant.unoccupiedestates;

import com.daredevil.landlordcommunication.models.Estates;

import java.util.List;

public interface View {
    void setPresenter(Presenter presenter);

    void showAdapter(List<Estates> estates);
}
