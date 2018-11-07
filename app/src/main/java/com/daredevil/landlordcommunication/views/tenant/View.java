package com.daredevil.landlordcommunication.views.tenant;

import com.daredevil.landlordcommunication.models.dto.UserDTO;

public interface View {
    void setPresenter(Presenter presenter);

    void showUserInfo(String name, String email, String rating, float sum);

    void setUserDTO(UserDTO userDTO);

    void showEstateAdapter();
}
