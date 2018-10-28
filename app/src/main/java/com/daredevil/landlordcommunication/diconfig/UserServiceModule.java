package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.repositories.Repository;
import com.daredevil.landlordcommunication.servieces.HttpUserService;
import com.daredevil.landlordcommunication.servieces.UserService;

import dagger.Module;
import dagger.Provides;

@Module
public class UserServiceModule {

    @Provides
    public UserService userService(Repository repository){
        return new HttpUserService(repository);
    }
}
