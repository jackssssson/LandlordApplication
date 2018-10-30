package com.daredevil.landlordcommunication.diconfig;



import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.async.AsyncRunnerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AsyncRunnerModule {
    @Provides
    @Singleton
    public AsyncRunner asyncRunner(){
        return new AsyncRunnerImpl();
    }
}
