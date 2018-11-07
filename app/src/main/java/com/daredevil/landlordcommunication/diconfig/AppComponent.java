package com.daredevil.landlordcommunication.diconfig;

import android.app.Application;

import com.daredevil.landlordcommunication.LandlordApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;


@Singleton
@Component(modules = {
        EstateAdapterModule.class,
        AsyncRunnerModule.class,
        UserServiceModule.class,
        JsonParserModule.class,
        RepositoriesModule.class,
        OkHttpModule.class,
        AppModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<LandlordApplication> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}