package com.daredevil.landlordcommunication.repositories;

import com.daredevil.landlordcommunication.models.dto.UserDTO;

import java.io.IOException;

public interface Repository {
    String addUser(UserDTO user, String type) throws IOException;

    UserDTO getByUserNameAndPassword(String userName, String password) throws IOException;

}
