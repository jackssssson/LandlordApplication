package com.daredevil.landlordcommunication.diconfig;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;


@Module
abstract class AppModule {
    //expose Application as an injectable context
    @Binds
    abstract Context bindContext(Application application);
}

