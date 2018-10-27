package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.http.HttpRequester;
import com.daredevil.landlordcommunication.http.OkHttpHttpRequester;

import dagger.Module;
import dagger.Provides;

@Module
public class OkHttpModule {
    @Provides
    public HttpRequester client(){
        return new OkHttpHttpRequester();
    }
}
