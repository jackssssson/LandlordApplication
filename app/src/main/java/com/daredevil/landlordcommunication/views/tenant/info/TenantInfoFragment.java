package com.daredevil.landlordcommunication.views.tenant.info;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.Messages;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.views.chat.ChatActivity;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TenantInfoFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.tenant.info.View,
        AdapterView.OnItemSelectedListener {

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

    @BindView(R.id.btn_value_tenant_info)
    Button mButtonPay;

    @BindView(R.id.btn_send_tenant_info)
    Button mButtonSend;

    @BindView(R.id.value_tenant_info)
    EditText mValueEnter;

    @BindView(R.id.rg_rating_tenant)
    RadioGroup mRadioGroup;

    @BindView(R.id.lv_tenant_info)
    ListView mListView;

    @BindView(R.id.spinner_tenant_messages)
    Spinner mSpinner;

    private String spinnerMessage;
    private ArrayAdapter<Messages> mAdapter;
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

        instantiateAdapter();

        spinner();

        mListView.setAdapter(mAdapter);

        Intent intent = Objects.requireNonNull(getActivity()).getIntent();

        estate = (Estates) intent.getSerializableExtra("estate");
        userName = intent.getStringExtra("userName");
        tenantId = intent.getIntExtra("tenantId", 0);

        buttonRate();

        mButtonChat.setOnClickListener(v -> presenter.chatClicked());

        mButtonPay.setOnClickListener(v -> presenter.payRent(mValueEnter.getText().toString(), estate.getEstateid()));

        mButtonSend.setOnClickListener(v -> presenter.postEstateMessage(
                spinnerMessage, estate.getEstateid(), tenantId));

        mSpinner.setOnItemSelectedListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.postIdEstate(estate.getEstateid(), estate);
        presenter.getMessagesForAdapter(estate.getEstateid());
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

    @Override
    public void showEstate(Estates estate) {
        runOnUi(() -> mUserOwed.setText(String.valueOf(estate.getPrice())));
    }

    @Override
    public void showMessagesInAdapter(List<Messages> messages) {
        runOnUi(() -> {
            mAdapter.clear();
            mAdapter.addAll(messages);});
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

    private void spinner() {
        ArrayAdapter<CharSequence> mSpinnerAdapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getContext()),
                R.array.spinner_content,
                android.R.layout.simple_spinner_item);

        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mSpinnerAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerMessage = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        spinnerMessage = "Please select a message";
    }

    private void instantiateAdapter(){
        mAdapter = new ArrayAdapter<Messages>(Objects.requireNonNull(getContext()),
                android.R.layout.simple_list_item_1){
            @NonNull
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView = view.findViewById(android.R.id.text1);

                textView.setTextColor(Color.CYAN);

                return view;
            }
        };
    }
}
