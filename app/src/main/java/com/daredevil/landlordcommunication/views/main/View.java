package com.daredevil.landlordcommunication.views.main;

public interface View {
    void setPresenter(Presenter presenter);

    void logInUser(boolean isConnected);
}
