package com.daredevil.landlordcommunication.servieces;

import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.repositories.UserRepository;

import java.io.IOException;
import java.util.List;

public class HttpUserService implements UserService{
    private UserRepository<User> mUserRepository;

    public HttpUserService(UserRepository<User> repository){
        this.mUserRepository =repository;
    }

    @Override
    public List<User> getAllCars() throws IOException {
        return mUserRepository.getAll();
    }

    @Override
    public User getInfoById(int id) throws IOException {
        return mUserRepository.getById(id);
    }

    @Override
    public void addCar(User car) throws IOException {
        mUserRepository.add(car);
    }

    @Override
    public void deleteCar(int id) throws IOException {
        mUserRepository.delete(id);
    }
}
