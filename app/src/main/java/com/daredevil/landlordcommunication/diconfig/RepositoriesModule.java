package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.http.HttpRequester;
import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.parser.JsonParser;
import com.daredevil.landlordcommunication.repositories.HttpRepository;
import com.daredevil.landlordcommunication.repositories.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    public Repository<User> userRepository(HttpRequester httpRequester, JsonParser<User> jsonParser){
        return new HttpRepository<>(httpRequester, jsonParser);
    }

    @Provides
    public Repository<UserDTO> userDTORepository(HttpRequester httpRequester, JsonParser<UserDTO> jsonParser){
        return new HttpRepository<>(httpRequester, jsonParser);
    }
}
