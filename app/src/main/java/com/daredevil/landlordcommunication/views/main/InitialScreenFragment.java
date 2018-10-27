package com.daredevil.landlordcommunication.views.main;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.views.CreateUser.CreateUserActivity;
import com.daredevil.landlordcommunication.views.landlord.LogInLandlord;

import java.io.IOException;
import java.util.Objects;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class InitialScreenFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.main.View {

    @BindView(R.id.user_name_plain)
    EditText userName;
    @BindView(R.id.password_plain)
    EditText password;

    @BindView(R.id.create_id)
    Button mCreate;

    @BindView(R.id.log_in_id)
    Button mLogIn;

    private Presenter presenter;

    @Inject
    public InitialScreenFragment() {
        // Required empty public constructor
    }


    @SuppressLint("StaticFieldLeak")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_initial_screen, container, false);

        ButterKnife.bind(this, view);

        mCreate.setOnClickListener(v -> startActivity(new Intent(getActivity(),
                CreateUserActivity.class)));


        mLogIn.setOnClickListener(v -> {
            try {
                presenter.logInUser(userName.getText().toString()
                        , password.getText().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void logInUser(boolean isConnected) {
        runOnUi(() -> {
            if (isConnected) {
                startActivity(new Intent(getActivity(), LogInLandlord.class));
            } else {
                Toast.makeText(getContext(), "Wrong user or password",
                        Toast.LENGTH_LONG).show();
            }
        });
    }


    private void runOnUi(Runnable action) {
        Objects.requireNonNull(getActivity()).runOnUiThread(action);
    }
}
