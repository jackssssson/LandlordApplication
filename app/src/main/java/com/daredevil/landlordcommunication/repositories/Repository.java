package com.daredevil.landlordcommunication.repositories;

import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.dto.UserDTO;

import java.io.IOException;

public interface Repository {
    String addUser(UserDTO user, String type) throws IOException;

    UserDTO getByUserNameAndPassword(String userName, String password) throws IOException;

    String createEstate(Estates estates, String name) throws IOException;

    Estates getEstates() throws IOException;

    UserDTO postIdEstate(int id) throws IOException;

    String setDueDate(String dueDate, int id) throws IOException;

    String rateUser(int rating, String name, String userName) throws IOException;

    String setOwed(String price, int id) throws IOException;
}
