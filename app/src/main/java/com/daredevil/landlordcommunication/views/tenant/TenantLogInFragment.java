package com.daredevil.landlordcommunication.views.tenant;


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
public class TenantLogInFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.tenant.View {

    @BindView(R.id.user_name_log_in)
    TextView mUserName;

    @BindView(R.id.user_email_log_tenant)
    TextView mUserEmail;

    @BindView(R.id.user_rating_log_in)
    TextView mUserRating;

    @BindView(R.id.btn_create_estate_log_in)
    Button mButtonCreate;

    private Presenter presenter;

    @Inject
    public TenantLogInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tenant_log_in, container, false);

        ButterKnife.bind(this, view);

        return  view;
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
