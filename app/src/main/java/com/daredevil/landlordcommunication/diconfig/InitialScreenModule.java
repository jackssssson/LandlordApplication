package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.views.main.InitialScreenFragment;
import com.daredevil.landlordcommunication.views.main.InitialScreenPresenter;
import com.daredevil.landlordcommunication.views.main.Presenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class InitialScreenModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract InitialScreenFragment initialScreenFragment();

    @ActivityScoped
    @Binds
    abstract Presenter taskPresenter(InitialScreenPresenter presenter);
}
