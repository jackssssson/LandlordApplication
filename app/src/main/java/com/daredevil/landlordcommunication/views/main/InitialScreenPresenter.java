package com.daredevil.landlordcommunication.views.main;


import javax.inject.Inject;

public class InitialScreenPresenter implements Presenter{

    private View mView;

    @Inject
    public InitialScreenPresenter() {
    }

    @Override
    public void setView(View view) {
        mView = view;
    }

    @Override
    public void showTestToast() {
        String text = "I am machine";
        mView.showTestToast(text);
    }
}
