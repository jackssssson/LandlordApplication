package com.daredevil.landlordcommunication.views.landlord.estate;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.dto.UserDTO;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandlordEstateFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.landlord.estate.View {

    @BindView(R.id.estate_name)
    EditText mEstateName;

    @BindView(R.id.price)
    EditText mEstatePrice;

    @BindView(R.id.address)
    EditText mEstateAddress;

    @BindView(R.id.btn_user_estate)
    Button mCreateEstate;

    @Inject
    public LandlordEstateFragment() {
        // Required empty public constructor
    }

    private Presenter presenter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_landlord_estate, container, false);

        ButterKnife.bind(this, view);

        Intent estateIntent = Objects.requireNonNull(getActivity()).getIntent();
        UserDTO userDTO = (UserDTO) estateIntent.getSerializableExtra("user");


        mCreateEstate.setOnClickListener(v -> {
            try {
                Estates estate = new Estates(
                        Float.valueOf(mEstatePrice.getText().toString()),
                        mEstateAddress.getText().toString());

                presenter.createEstate(estate, userDTO.getUserName());
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Invalid price!", Toast.LENGTH_SHORT).show();
            }
        });


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

    @Override
    public void showEstateCreated() {
        runOnUi(() -> {
            Toast.makeText(getContext(), "Estate created", Toast.LENGTH_LONG).show();
            //startActivity(new Intent(getActivity(), LandlordLogInActivity.class));
            Objects.requireNonNull(getActivity()).finish();
        });
    }

    @Override
    public void showErrorMessage(String message) {
        runOnUi(() -> Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show());
    }

    private void runOnUi(Runnable action) {
        Objects.requireNonNull(getActivity()).runOnUiThread(action);
    }
}
