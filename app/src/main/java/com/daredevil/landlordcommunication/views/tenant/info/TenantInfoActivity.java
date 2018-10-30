package com.daredevil.landlordcommunication.views.tenant.info;

import android.os.Bundle;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class TenantInfoActivity extends DaggerAppCompatActivity {

    @Inject
    TenantInfoFragment mFragment;

    @Inject
    TenantInfoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_info);

        mFragment.setPresenter(presenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.tenant_info_fragment, mFragment)
                .commit();
    }
}
