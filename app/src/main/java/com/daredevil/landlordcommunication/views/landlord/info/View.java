package com.daredevil.landlordcommunication.views.landlord.info;

import com.daredevil.landlordcommunication.models.dto.UserDTO;

public interface View {
    void setPresenter(Presenter presenter);

    void showUserDTO(UserDTO userDTO);

    void showMessage(String name);

    void buttonChat(int id);
}
