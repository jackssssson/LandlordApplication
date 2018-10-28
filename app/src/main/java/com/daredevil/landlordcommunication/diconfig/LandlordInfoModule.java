package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.views.landlord.info.LandlordInfoFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LandlordInfoModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract LandlordInfoFragment landlordInfoFragment();

//    @ActivityScoped
//    @Binds
//    abstract Presenter taskPresenter(InitialScreenPresenter presenter);
}
