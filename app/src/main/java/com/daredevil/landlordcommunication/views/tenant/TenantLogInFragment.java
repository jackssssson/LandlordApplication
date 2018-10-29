package com.daredevil.landlordcommunication.views.tenant;


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
public class TenantLogInFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.tenant.View{

    @Inject
    public TenantLogInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tenant_log_in, container, false);
    }

}
