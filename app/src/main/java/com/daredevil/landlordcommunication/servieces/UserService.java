package com.daredevil.landlordcommunication.servieces;

import com.daredevil.landlordcommunication.models.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<User> getAllCars() throws IOException;
//    User getInfoById(int id) throws IOException;
//    void addCar(User car) throws IOException;
//    void deleteCar(int id) throws IOException;
}
