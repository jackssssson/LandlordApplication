package com.daredevil.landlordcommunication.views.tenant.info;

import javax.inject.Inject;

public class TenantInfoPresenter implements Presenter{

    private View mView;

    @Inject
    TenantInfoPresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }
}
