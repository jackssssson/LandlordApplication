package com.daredevil.landlordcommunication.views.CreateUser;

import com.daredevil.landlordcommunication.models.dto.UserDTO;

import java.io.IOException;

public interface Presenter {
    void setView(View view);

    void createUserDTO(UserDTO user, String type) throws IOException;
}
