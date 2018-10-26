package com.daredevil.landlordcommunication.views.CreateUser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daredevil.landlordcommunication.R;

public class CreateUserActivity extends AppCompatActivity {

    private CreateUserFragment mFragment;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        presenter = new CreateUserPresenter();
        mFragment = CreateUserFragment.newInstance();
        mFragment.setPresenter(presenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_create, mFragment)
                .commit();
    }
}
