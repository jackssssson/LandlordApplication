package com.daredevil.landlordcommunication.views.tenant;

import android.os.Bundle;

import com.daredevil.landlordcommunication.R;

import dagger.android.support.DaggerAppCompatActivity;

public class LogInTenant extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_tenant);
    }
}
