package com.daredevil.landlordcommunication.views.landlord.info;

import javax.inject.Inject;

public class LandlordInfoPresenter implements Presenter {

    private View mView;

    @Inject
    LandlordInfoPresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }
}
