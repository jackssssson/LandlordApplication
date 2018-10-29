package com.daredevil.landlordcommunication.views.landlord.estate;

public interface View {
    void setPresenter(Presenter presenter);

    void showEstateCreated();

    void showErrorMessage(String message);
}
