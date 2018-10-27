package com.daredevil.landlordcommunication.servieces;

import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.repositories.Repository;

import java.io.IOException;

import javax.inject.Inject;

public class HttpUserService implements UserService {
    @Inject
    Repository<User> mUserRepository;

    @Inject
    public HttpUserService(Repository<User> repository) {
        this.mUserRepository = repository;
    }

    @Override
    public User getUserById(int id) throws IOException {
        return null;
    }
}
