package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.views.landlord.info.LandlordInfoFragment;
import com.daredevil.landlordcommunication.views.landlord.info.LandlordInfoPresenter;
import com.daredevil.landlordcommunication.views.landlord.info.Presenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class LandlordInfoModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract LandlordInfoFragment landlordInfoFragment();

    @ActivityScoped
    @Binds
    abstract Presenter taskPresenter(LandlordInfoPresenter presenter);
}
