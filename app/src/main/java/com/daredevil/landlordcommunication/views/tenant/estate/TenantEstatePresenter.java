package com.daredevil.landlordcommunication.views.tenant.estate;

import javax.inject.Inject;

public class TenantEstatePresenter implements Presenter{

    private View mView;

    @Inject
    TenantEstatePresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }
}
