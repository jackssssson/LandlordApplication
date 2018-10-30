package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.views.tenant.unoccupiedestates.Presenter;
import com.daredevil.landlordcommunication.views.tenant.unoccupiedestates.TenantUnOccupiedFragment;
import com.daredevil.landlordcommunication.views.tenant.unoccupiedestates.TenantUnOccupiedPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TenantUnoOccupiedModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract TenantUnOccupiedFragment tenantLogInFragment();

    @ActivityScoped
    @Binds
    abstract Presenter presenter(TenantUnOccupiedPresenter presenter);
}
