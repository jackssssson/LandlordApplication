package com.daredevil.landlordcommunication.views.landlord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

public class LandlordLogInActivity extends AppCompatActivity {

    @Inject
    LandlordLogInFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_log_in);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.log_fragment, mFragment)
                .commit();
    }
}
