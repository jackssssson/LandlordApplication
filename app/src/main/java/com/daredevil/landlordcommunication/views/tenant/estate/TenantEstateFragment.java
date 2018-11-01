package com.daredevil.landlordcommunication.views.tenant.estate;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.models.Estates;

import java.util.Objects;

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

    @BindView(R.id.user_address_tenant_estate_landlord)
    TextView mUserAddress;

    @BindView(R.id.btn_rent_tenant_estate)
    Button mButtonRent;

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

        Intent intent = Objects.requireNonNull(getActivity()).getIntent();
        Estates estate = (Estates) intent.getSerializableExtra("estate");
        int userId = intent.getIntExtra("id", 0);
        presenter.setEstate(estate);
        presenter.setUserId(userId);

        mButtonRent.setOnClickListener(v -> presenter.rateEstate());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadInfo();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showUserInfo(String name, String email, String rating, String price, String address) {
        runOnUi(() -> {
            mUserName.setText(name);
            mUserEmail.setText(email);
            mUserRating.setText(rating);
            mUserPrice.setText(price);
            mUserAddress.setText(address);
        });
    }

    @Override
    public void showMessage(String message) {
        runOnUi(() -> Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show());
    }

    private void runOnUi(Runnable action) {
        Objects.requireNonNull(getActivity()).runOnUiThread(action);
    }
}
