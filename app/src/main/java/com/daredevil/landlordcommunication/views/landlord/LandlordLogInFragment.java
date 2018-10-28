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
import com.daredevil.landlordcommunication.views.landlord.estate.LandlordEstateActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandlordLogInFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.landlord.View{

    @BindView(R.id.tv_name)
    TextView mUserName;

    @BindView(R.id.tv_email)
    TextView mUserEmail;

    @BindView(R.id.tv_userRating)
    TextView mUserRating;

    @BindView(R.id.lv_items)
    ListView mListView;

    @BindView(R.id.btn_createEstate)
    Button mCreateEstate;

    //private ArrayAdapter<ListView> adapter;

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

        mCreateEstate.setOnClickListener(v -> startActivity(new Intent(getActivity(),
                LandlordEstateActivity.class)));

        return view;
    }

}
