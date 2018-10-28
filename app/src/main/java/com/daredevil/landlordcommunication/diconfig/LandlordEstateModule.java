package com.daredevil.landlordcommunication.diconfig;



import com.daredevil.landlordcommunication.views.landlord.estate.LandlordEstateFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LandlordEstateModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract LandlordEstateFragment landlordEstateFragment();

//    @ActivityScoped
//    @Binds
//    abstract Presenter taskPresenter(InitialScreenPresenter presenter);
}
