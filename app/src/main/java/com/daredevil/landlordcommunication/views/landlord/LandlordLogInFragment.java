package com.daredevil.landlordcommunication.views.landlord;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.views.landlord.estate.LandlordEstateActivity;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandlordLogInFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.landlord.View{

    @BindView(R.id.user_name_log_in)
    TextView mUserName;

    @BindView(R.id.user_email_log_in)
    TextView mUserEmail;

    @BindView(R.id.user_rating_log_in)
    TextView mUserRating;

    @BindView(R.id.lv_estate_log_in)
    ListView mListView;

    @BindView(R.id.btn_create_estate_log_in)
    Button mCreateEstate;

    private Presenter presenter;

    private ArrayAdapter<String> mAdapter;

    @Inject
    public LandlordLogInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_landlord_log_in, container, false);

        ButterKnife.bind(this, view);

       mAdapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()),
               android.R.layout.simple_list_item_1);

       mListView.setAdapter(mAdapter);

       mAdapter.addAll("Batman");

        Intent intent = Objects.requireNonNull(getActivity()).getIntent();
        UserDTO userDTO = (UserDTO) intent.getSerializableExtra("user");
        presenter.setUser(userDTO);


        Intent estateIntent = new Intent(getActivity(),
                LandlordEstateActivity.class);
        estateIntent.putExtra("user", userDTO);
        mCreateEstate.setOnClickListener(v -> startActivity(estateIntent));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadUser();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showUserInfo(String name, String email, String rating) {
        runOnUi(() -> {
            mUserName.setText(name);
            mUserEmail.setText(email);
            mUserRating.setText(rating);
        });
    }

    @Override
    public void showEstate() {

    }

    private void runOnUi(Runnable action) {
        Objects.requireNonNull(getActivity()).runOnUiThread(action);
    }
}
