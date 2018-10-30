package com.daredevil.landlordcommunication.views.tenant.unoccupiedestates;

import javax.inject.Inject;

public class TenantUnOccupiedPresenter implements Presenter{

    private View mView;

    @Inject
    TenantUnOccupiedPresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }
}
