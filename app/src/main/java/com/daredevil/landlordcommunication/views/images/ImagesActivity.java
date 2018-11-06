package com.daredevil.landlordcommunication.views.images;

import android.os.Bundle;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class ImagesActivity extends DaggerAppCompatActivity {

    @Inject
    ImagesFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.image_fragment, mFragment)
                .commit();

    }
}
