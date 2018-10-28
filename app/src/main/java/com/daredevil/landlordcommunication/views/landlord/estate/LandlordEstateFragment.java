package com.daredevil.landlordcommunication.views.landlord.estate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandlordEstateFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.landlord.estate.View{

    @BindView(R.id.estate_name)
    EditText estateName;

    @BindView(R.id.price)
    EditText price;

    @BindView(R.id.address)
    EditText address;

    @BindView(R.id.btn_user_estate)
    Button createEstate;

    @Inject
    public LandlordEstateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_landlord_estate, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

}
