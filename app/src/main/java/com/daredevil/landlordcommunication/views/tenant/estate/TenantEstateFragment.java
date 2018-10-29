package com.daredevil.landlordcommunication.views.tenant.estate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daredevil.landlordcommunication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TenantEstateFragment extends Fragment {


    public TenantEstateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tenant_estate, container, false);
    }

}
