package com.daredevil.landlordcommunication.views.landlord.info;

import android.os.Bundle;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class LandlordInfoActivity extends DaggerAppCompatActivity {

    @Inject
    LandlordInfoFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_info);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.info_fragment, mFragment)
                .commit();
    }
}
