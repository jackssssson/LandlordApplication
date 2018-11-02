package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.views.chat.ChatFragment;
import com.daredevil.landlordcommunication.views.chat.ChatPresenter;
import com.daredevil.landlordcommunication.views.chat.Presenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ChatModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract ChatFragment tenantLogInFragment();

    @ActivityScoped
    @Binds
    abstract Presenter presenter(ChatPresenter presenter);
}
