package com.daredevil.landlordcommunication.views.landlord.info;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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
public class LandlordInfoFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.landlord.info.View {

    @BindView(R.id.user_name_info)
    TextView mUserName;

    @BindView(R.id.user_email_info)
    TextView mUserEmail;

    @BindView(R.id.user_rate_info_tenant)
    TextView mUserRate;

    @BindView(R.id.user_due_date_info)
    TextView mDueDate;

    @BindView(R.id.user_is_occupied)
    TextView mUserIsOccupied;

    @BindView(R.id.owed_info)
    EditText mOwedInfo;

    @BindView(R.id.user_set_due_date)
    EditText mSetDueDate;

    @BindView(R.id.btn_owed)
    Button mButtonOwedInfo;

    @BindView(R.id.btn_rate_info)
    Button mButtonRate;

    @BindView(R.id.btn_set_info)
    Button mButtonSet;

    @BindView(R.id.btn_chat_info)
    Button mButtonChat;

    @BindView(R.id.rg_rating)
    RadioGroup mRadioGroup;

    @BindView(R.id.user_owed_info)
    TextView mUserOwed;

    private Presenter presenter;

    private Estates estates;

    private String name;

    @Inject
    public LandlordInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_landlord_info, container, false);

        ButterKnife.bind(this, view);

        Intent intent = Objects.requireNonNull(getActivity()).getIntent();
        estates = (Estates) intent.getSerializableExtra("estate");

        name = intent.getStringExtra("userName");

        buttonSetDueDate();

        buttonRate();

        buttonSetOwed();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.postIdEstate(estates.getEstateid(), estates);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showUserDTO(UserDTO userDTO) {
        runOnUi(() -> {
            mUserName.setText(userDTO.getUserName());
            mUserEmail.setText(userDTO.getUserEmail());
            mUserRate.setText(userDTO.getUserRating());

            String occupied;
            if (estates.isOccupied()) {
                occupied = "true";
            } else {
                occupied = "false";
            }

            mUserIsOccupied.setText(occupied);
            mDueDate.setText(estates.getDuedate());
            mUserOwed.setText(String.valueOf(estates.getPrice()));
        });
    }

    @Override
    public void showMessage(String name) {
        runOnUi(() -> Toast.makeText(getContext(), name, Toast.LENGTH_LONG).show());
    }

    private void runOnUi(Runnable action) {
        Objects.requireNonNull(getActivity()).runOnUiThread(action);
    }

    private void buttonRate() {
        mButtonRate.setOnClickListener(v -> {
            int rating = 0;
            int radioButtonId = mRadioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = mRadioGroup.findViewById(radioButtonId);

            if (radioButton == null) {
                showMessage("Please select rating");
            } else {
                switch (radioButtonId) {
                    case R.id.rb_1:
                        rating = 1;
                        break;
                    case R.id.rb_2:
                        rating = 2;
                        break;
                    case R.id.rb_3:
                        rating = 3;
                        break;
                    case R.id.rb_4:
                        rating = 4;
                        break;
                    case R.id.rb_5:
                        rating = 5;
                        break;
                }
            }

            presenter.rateUser(rating, name);

        });
    }

    public void buttonSetDueDate() {
        mButtonSet.setOnClickListener(v -> {
            String result;

            if (mSetDueDate.getText().toString().equals("")) {
                result = "error";
            } else {
                result = mSetDueDate.getText().toString();
            }

            presenter.setDueDate(
                    result, estates.getEstateid());


        });
    }

    public void buttonSetOwed() {
        mButtonOwedInfo.setOnClickListener(v -> {
            String result;

            if (mOwedInfo.getText().toString().equals("")) {
                result = "error";
            } else {
                result = mOwedInfo.getText().toString();
                mUserOwed.setText(result);
            }

            presenter.setOwed(
                    result, estates.getEstateid());
        });
    }

}
