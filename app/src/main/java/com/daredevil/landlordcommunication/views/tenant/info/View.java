package com.daredevil.landlordcommunication.views.tenant.info;

import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.Messages;
import com.daredevil.landlordcommunication.models.dto.UserDTO;

import java.util.List;

public interface View {
    void setPresenter(Presenter presenter);

    void showUserDTO(UserDTO userDTO);

    void showMessage(String name);

    void buttonChat(int id);

    void showEstate(Estates estate);

    void showMessagesInAdapter(List<Messages> messages);

    void hideLoading();

    void showLoading();

    void hideAdapterLoading();

    void showAdapterLoading();
}
