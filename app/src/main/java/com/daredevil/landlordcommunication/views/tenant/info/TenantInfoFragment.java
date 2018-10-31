package com.daredevil.landlordcommunication.views.tenant.info;


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
public class TenantInfoFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.tenant.info.View {

    @BindView(R.id.user_name_tenant_info_landlord)
    TextView mUserName;

    @BindView(R.id.user_email_tenant_info_landlord)
    TextView mUserEmail;

    @BindView(R.id.user_rating_tenant_info_landlord)
    TextView mUserRating;

    @BindView(R.id.user_owed_tenant_info_landlord)
    TextView mUserOwed;

    @BindView(R.id.user_due_date_tenant_info_landlord)
    TextView mUserDueDate;

    @BindView(R.id.btn_tenant_info_rate)
    Button mButtonRate;

    @BindView(R.id.btn_tenant_info_chat)
    Button mButtonChat;

    private Presenter presenter;

    @Inject
    public TenantInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tenant_info, container, false);

        ButterKnife.bind(this, view);

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
}
