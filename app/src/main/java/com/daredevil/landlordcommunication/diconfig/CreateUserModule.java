package com.daredevil.landlordcommunication.diconfig;


import com.daredevil.landlordcommunication.views.CreateUser.CreateUserFragment;
import com.daredevil.landlordcommunication.views.CreateUser.CreateUserPresenter;
import com.daredevil.landlordcommunication.views.CreateUser.Presenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CreateUserModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract CreateUserFragment createUserFragment();

    @ActivityScoped
    @Binds
    abstract Presenter taskPresenter(CreateUserPresenter presenter);
}
