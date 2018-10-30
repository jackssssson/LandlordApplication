package com.daredevil.landlordcommunication.views.tenant.estate;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TenantEstateFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.tenant.estate.View{

    @BindView(R.id.user_name_tenant_estate_landlord)
    TextView mUserName;

    @BindView(R.id.user_email_tenant_estate_landlord)
    TextView mUserEmail;

    @BindView(R.id.user_rating_tenant_estate_landlord)
    TextView mUserRating;

    @BindView(R.id.user_price_tenant_estate_landlord)
    TextView mUserPrice;

    @BindView(R.id.btn_chat_tenant_estate)
    Button mButtonChat;

    private Presenter presenter;

    @Inject
    public TenantEstateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tenant_estate, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
