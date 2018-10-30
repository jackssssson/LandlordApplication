package com.daredevil.landlordcommunication.views.tenant.unoccupiedestates;

import android.os.Bundle;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class TenantUnOccupiedActivity extends DaggerAppCompatActivity {

    @Inject
    TenantUnOccupiedFragment mFragment;

    @Inject
    TenantUnOccupiedPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_un_occupied);

        mFragment.setPresenter(presenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.unoccupied_tenant_fragment, mFragment)
                .commit();
    }
}
