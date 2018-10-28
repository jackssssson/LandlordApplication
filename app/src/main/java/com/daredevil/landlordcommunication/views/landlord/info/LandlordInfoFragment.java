package com.daredevil.landlordcommunication.views.landlord.info;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandlordInfoFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.landlord.info.View{


    @Inject
    public LandlordInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_landlord_info, container, false);



        return view;
    }

}
