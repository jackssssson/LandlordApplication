package com.daredevil.landlordcommunication.servieces;

import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.repositories.Repository;

import java.io.IOException;
import java.util.List;

public class HttpUserService implements UserService{
    private Repository<User> mUserRepository;

    public HttpUserService(Repository<User> repository){
        this.mUserRepository =repository;
    }

    @Override
    public List<User> getAllCars() throws IOException {
        return mUserRepository.getAll();
    }
}
