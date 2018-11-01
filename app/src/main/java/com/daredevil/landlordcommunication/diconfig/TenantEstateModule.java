package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.views.tenant.estate.Presenter;
import com.daredevil.landlordcommunication.views.tenant.estate.TenantEstateFragment;
import com.daredevil.landlordcommunication.views.tenant.estate.TenantEstatePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class TenantEstateModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract TenantEstateFragment tenantEstateFragment();

    @ActivityScoped
    @Binds
    abstract Presenter presenter(TenantEstatePresenter presenter);
}
