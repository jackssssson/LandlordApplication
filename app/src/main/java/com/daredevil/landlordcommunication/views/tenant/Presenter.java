package com.daredevil.landlordcommunication.views.tenant;

import com.daredevil.landlordcommunication.models.dto.UserDTO;

public interface Presenter {
    void setView(View view);

    void loadUser();

    void setUser(UserDTO user);

    void refreshUserDto(int id);
}
