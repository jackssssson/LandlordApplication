package com.daredevil.landlordcommunication.views.tenant;

public interface View {
    void setPresenter(Presenter presenter);

    void showUserInfo(String name, String email, String rating);
}
