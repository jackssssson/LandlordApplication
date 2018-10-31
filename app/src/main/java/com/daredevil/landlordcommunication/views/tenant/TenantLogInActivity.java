package com.daredevil.landlordcommunication.views.tenant;

import android.os.Bundle;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class TenantLogInActivity extends DaggerAppCompatActivity {

    @Inject
    TenantLogInFragment mFragment;

    @Inject
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_log_in);

        mFragment.setPresenter(presenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.log_in_tenant, mFragment)
                .commit();
    }
}
