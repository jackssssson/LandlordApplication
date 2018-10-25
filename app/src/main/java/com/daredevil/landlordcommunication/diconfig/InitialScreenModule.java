package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.views.main.InitialScreenFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class InitialScreenModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract InitialScreenFragment initialScreenFragment();

//    @ActivityScoped
//    @Binds abstract TasksContract.Presenter taskPresenter(TasksPresenter presenter);
}
