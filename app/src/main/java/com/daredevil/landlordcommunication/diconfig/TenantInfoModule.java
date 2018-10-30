package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.views.tenant.info.Presenter;
import com.daredevil.landlordcommunication.views.tenant.info.TenantInfoFragment;
import com.daredevil.landlordcommunication.views.tenant.info.TenantInfoPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TenantInfoModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract TenantInfoFragment tenantInfoFragment();

    @ActivityScoped
    @Binds
    abstract Presenter presenter(TenantInfoPresenter presenter);
}
