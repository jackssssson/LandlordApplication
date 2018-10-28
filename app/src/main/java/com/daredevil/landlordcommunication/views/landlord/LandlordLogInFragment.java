package com.daredevil.landlordcommunication.views.landlord;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandlordLogInFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.landlord.View{

    @Inject
    public LandlordLogInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_landlord_log_in, container, false);
    }

}
