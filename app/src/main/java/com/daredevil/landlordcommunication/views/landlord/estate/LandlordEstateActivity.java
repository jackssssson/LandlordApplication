package com.daredevil.landlordcommunication.views.landlord.estate;

import android.os.Bundle;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class LandlordEstateActivity extends DaggerAppCompatActivity {

    @Inject
    LandlordEstateFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_estate);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.estate_fragment, mFragment)
                .commit();
    }
}
