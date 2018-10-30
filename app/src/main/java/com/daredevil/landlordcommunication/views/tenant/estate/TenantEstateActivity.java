package com.daredevil.landlordcommunication.views.tenant.estate;

import android.os.Bundle;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class TenantEstateActivity extends DaggerAppCompatActivity {

    @Inject
    TenantEstateFragment mFragment;

    @Inject
    Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_estate);

        mFragment.setPresenter(mPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.tenant_estate_fragment, mFragment)
                .commit();
    }
}
