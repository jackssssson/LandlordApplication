package com.daredevil.landlordcommunication.views.tenant;

import javax.inject.Inject;

public class TenantLogInPresenter implements Presenter {

    private View mView;

    @Inject
    TenantLogInPresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }
}
