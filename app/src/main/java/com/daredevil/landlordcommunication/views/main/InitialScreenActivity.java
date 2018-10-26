package com.daredevil.landlordcommunication.views.main;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.views.CreateUser.CreateUserActivity;
import com.daredevil.landlordcommunication.views.landlord.LogInLandlord;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


public class InitialScreenActivity extends DaggerAppCompatActivity{

    private InitialScreenFragment mMainFragment;

    private InitialScreenPresenter mPresenter;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_screen);

        mPresenter = new InitialScreenPresenter();
        mMainFragment = new InitialScreenFragment();
        mMainFragment.setPresenter(mPresenter);

        mMainFragment.setPresenter(mPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_initial, mMainFragment)
                .commit();
    }
}
