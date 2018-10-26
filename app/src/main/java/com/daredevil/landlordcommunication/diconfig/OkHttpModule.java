package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.http.HttpRequester;
import com.daredevil.landlordcommunication.http.OkHttpHttpRequester;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class OkHttpModule {
    @Provides
    public HttpRequester client(){
        return new OkHttpHttpRequester();
    }
}
