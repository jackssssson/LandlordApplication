package com.daredevil.landlordcommunication.views.chat;

import android.os.Bundle;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class ChatActivity extends DaggerAppCompatActivity {

    @Inject
    ChatFragment mFragment;

    @Inject
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mFragment.setPresenter(presenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.chat_fragment, mFragment)
                .commit();
    }
}
