package com.daredevil.landlordcommunication.views.main;

import com.daredevil.landlordcommunication.models.dto.UserDTO;

public interface View {
    void setPresenter(Presenter presenter);

    void logInUser(UserDTO user);

    void savePreference(String userName, String password);

    void setNotification(String user_name);
}
