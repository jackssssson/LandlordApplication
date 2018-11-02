package com.daredevil.landlordcommunication.views.tenant.info;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.views.chat.ChatActivity;

import java.util.Objects;

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

    @BindView(R.id.rg_rating_tenant)
    RadioGroup mRadioGroup;

    private Presenter presenter;
    private Estates estate;
    private String userName;
    private int tenantId;


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

        Intent intent = Objects.requireNonNull(getActivity()).getIntent();
        estate = (Estates) intent.getSerializableExtra("estate");
        userName = intent.getStringExtra("userName");
        tenantId = intent.getIntExtra("tenantId", 0);

        buttonRate();

        mButtonChat.setOnClickListener(v -> presenter.chatClicked());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.postIdEstate(estate.getEstateid(), estate);

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
            mUserRating.setText(userDTO.getUserRating());
            mUserDueDate.setText(estate.getDuedate());
            mUserOwed.setText(String.valueOf(estate.getPrice()));
        });
    }

    @Override
    public void showMessage(String name) {
        runOnUi(() -> Toast.makeText(getContext(), name, Toast.LENGTH_LONG).show());
    }

    @Override
    public void buttonChat(int id) {
        Intent intent = new Intent(getActivity(), ChatActivity.class);
        intent.putExtra("sender", id);
        intent.putExtra("recipient", tenantId);
        startActivity(intent);
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
                    case R.id.rb_1_tenant:
                        rating = 1;
                        break;
                    case R.id.rb_2_tenant:
                        rating = 2;
                        break;
                    case R.id.rb_3_tenant:
                        rating = 3;
                        break;
                    case R.id.rb_4_tenant:
                        rating = 4;
                        break;
                    case R.id.rb_5_tenant:
                        rating = 5;
                        break;
                }
            }

           presenter.rateUser(rating, userName);

        });
    }
}
