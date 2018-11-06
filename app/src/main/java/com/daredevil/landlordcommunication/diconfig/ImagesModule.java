package com.daredevil.landlordcommunication.diconfig;

import com.daredevil.landlordcommunication.views.images.ImagesFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ImagesModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract ImagesFragment imagesFragment();
}
