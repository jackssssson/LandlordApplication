package com.daredevil.landlordcommunication;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class LandlordApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
    }
}
