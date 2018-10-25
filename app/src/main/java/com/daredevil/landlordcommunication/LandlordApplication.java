package com.daredevil.landlordcommunication;



import com.daredevil.landlordcommunication.diconfig.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class LandlordApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
      return DaggerAppComponent.builder().application(this).build();
    }
}
