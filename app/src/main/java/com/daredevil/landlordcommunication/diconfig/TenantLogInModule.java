package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.views.tenant.Presenter;
import com.daredevil.landlordcommunication.views.tenant.TenantLogInFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TenantLogInModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract TenantLogInFragment tenantLogInFragment();

    @ActivityScoped
    @Binds
    abstract Presenter taskPresenter(TenantLogInFragment presenter);
}
