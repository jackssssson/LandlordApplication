package com.daredevil.landlordcommunication.views.main;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.daredevil.landlordcommunication.R;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class InitialScreenFragment extends Fragment implements com.daredevil.landlordcommunication.views.main.View{

    @BindView(R.id.create_id)
    Button mCreate;

    @BindView(R.id.log_in_id)
    Button mLogIn;

    private Presenter presenter;
    private Navigator navigator;

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

        mCreate.setOnClickListener(v -> navigator.navigateCreateButton());
        mLogIn.setOnClickListener(v -> navigator.navigateLogInButton());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.showTestToast();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showTestToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }


//    private void runOnUi(Runnable action) {
//        Objects.requireNonNull(getActivity()).runOnUiThread(action);
//    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }
}
