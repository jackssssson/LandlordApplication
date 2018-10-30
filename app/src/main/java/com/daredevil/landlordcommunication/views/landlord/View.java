package com.daredevil.landlordcommunication.views.landlord;

public interface View {
    void setPresenter(Presenter presenter);

    void showUserInfo(String name, String email, String rating);

    void showEstate();
}
