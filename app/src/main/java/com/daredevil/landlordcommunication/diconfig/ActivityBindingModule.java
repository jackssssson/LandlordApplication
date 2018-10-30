package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.views.CreateUser.CreateUserActivity;
import com.daredevil.landlordcommunication.views.landlord.LandlordLogInActivity;
import com.daredevil.landlordcommunication.views.landlord.estate.LandlordEstateActivity;
import com.daredevil.landlordcommunication.views.landlord.info.LandlordInfoActivity;
import com.daredevil.landlordcommunication.views.main.InitialScreenActivity;
import com.daredevil.landlordcommunication.views.tenant.TenantLogInActivity;
import com.daredevil.landlordcommunication.views.tenant.estate.TenantEstateActivity;
import com.daredevil.landlordcommunication.views.tenant.info.TenantInfoActivity;
import com.daredevil.landlordcommunication.views.tenant.unoccupiedestates.TenantUnOccupiedActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever module ActivityBindingModule is on,
 * in our case that will be AppComponent. The beautiful part about this setup is that you never need to tell AppComponent that it is going to have all these subcomponents
 * nor do you need to tell these subcomponents that AppComponent exists.
 * We are also telling Dagger.Android that this generated SubComponent needs to include the specified modules and be aware of a scope annotation @ActivityScoped
 * When Dagger.Android annotation processor runs it will create 4 subcomponents for us.
 */
@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = {InitialScreenModule.class})
    abstract InitialScreenActivity initialScreenActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {CreateUserModule.class})
    abstract CreateUserActivity createUserActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {LandlordLogInModule.class})
    abstract LandlordLogInActivity landlordLogInActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {LandlordEstateModule.class})
    abstract LandlordEstateActivity landlordEstateActivity();


    @ActivityScoped
    @ContributesAndroidInjector(modules = {LandlordInfoModule.class})
    abstract LandlordInfoActivity landlordInfoActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {TenantLogInModule.class})
    abstract TenantLogInActivity tenantLogInActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {TenantEstateModule.class})
    abstract TenantEstateActivity tenantEstateActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {TenantInfoModule.class})
    abstract TenantInfoActivity tenantInfoActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {TenantUnoOccupiedModule.class})
    abstract TenantUnOccupiedActivity tenantUnOccupiedActivity();
}