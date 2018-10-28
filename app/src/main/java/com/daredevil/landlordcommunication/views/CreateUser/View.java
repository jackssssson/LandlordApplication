package com.daredevil.landlordcommunication.views.CreateUser;

public interface View {
    void setPresenter(Presenter presenter);

    void createUserDTO(String isCreated);

    void typeWarning();
}
