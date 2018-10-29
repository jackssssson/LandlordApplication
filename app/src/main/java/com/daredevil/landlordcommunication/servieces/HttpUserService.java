package com.daredevil.landlordcommunication.servieces;

import com.daredevil.landlordcommunication.repositories.Repository;

import javax.inject.Inject;

public class HttpUserService implements UserService {
    @Inject
    Repository mUserRepository;

    @Inject
    public HttpUserService(Repository repository) {
        this.mUserRepository = repository;
    }


}
