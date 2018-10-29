package com.daredevil.landlordcommunication.views.tenant;

import android.os.Bundle;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class TenantLogInActivity extends DaggerAppCompatActivity {

    @Inject
    TenantLogInFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_log_in);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.log_in_tenant, mFragment)
                .commit();
    }
}
