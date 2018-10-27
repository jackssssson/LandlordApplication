package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.parser.GsonParser;
import com.daredevil.landlordcommunication.parser.JsonParser;

import dagger.Module;
import dagger.Provides;

@Module
public class JsonParserModule {
    @Provides
    public JsonParser<User> userJsonParser(){
        return new GsonParser<>(User.class);
    }

    @Provides
    public JsonParser<UserDTO> userDTOJsonParser(){
        return new GsonParser<>(UserDTO.class);
    }
}
