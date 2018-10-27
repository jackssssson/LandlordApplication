package com.daredevil.landlordcommunication.views.main;

import com.daredevil.landlordcommunication.R;

import android.annotation.SuppressLint;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


public class InitialScreenActivity extends DaggerAppCompatActivity{

    @Inject
    InitialScreenFragment mMainFragment;

    @Inject
    InitialScreenPresenter mPresenter;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_screen);

        mMainFragment.setPresenter(mPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_initial, mMainFragment)
                .commit();
    }
}
