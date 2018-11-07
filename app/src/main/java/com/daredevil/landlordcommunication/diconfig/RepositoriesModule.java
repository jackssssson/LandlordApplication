package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.http.HttpRequester;
import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.parser.JsonParser;
import com.daredevil.landlordcommunication.repositories.HttpRepository;
import com.daredevil.landlordcommunication.repositories.InMemoryRepository;
import com.daredevil.landlordcommunication.repositories.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    public Repository userRepository(HttpRequester mHttpRequester,
                                     JsonParser<User> mJsonParserUser,
                                           JsonParser<UserDTO> mJsonParserDTO){
        return new HttpRepository(mHttpRequester, mJsonParserUser, mJsonParserDTO);
    }

}
