package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.views.landlord.LandlordLogInFragment;
import com.daredevil.landlordcommunication.views.landlord.LandlordLogInPresenter;
import com.daredevil.landlordcommunication.views.landlord.Presenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class LandlordLogInModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract LandlordLogInFragment landlordLogInFragment();

    @ActivityScoped
    @Binds
    abstract Presenter taskPresenter(LandlordLogInPresenter presenter);
}
