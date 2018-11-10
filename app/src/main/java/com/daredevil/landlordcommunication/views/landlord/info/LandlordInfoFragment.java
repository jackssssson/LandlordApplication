package com.daredevil.landlordcommunication.views.landlord.info;


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
public class LandlordInfoFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.landlord.info.View, AdapterView.OnItemSelectedListener{

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

    @BindView(R.id.btn_send_info)
    Button mButtonSend;

    @BindView(R.id.rg_rating)
    RadioGroup mRadioGroup;

    @BindView(R.id.user_owed_info)
    TextView mUserOwed;

    @BindView(R.id.lv_landlord_info)
    ListView mListView;

    @BindView(R.id.spinner_messages)
    Spinner mSpinner;


    private ArrayAdapter<Messages> mAdapter;
    private Presenter presenter;
    private Estates estates;
    private String name;
    private int userId;
    private String spinnerMessage;

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

        instantiateAdapter();


        spinner();

        mListView.setAdapter(mAdapter);

        Intent intent = Objects.requireNonNull(getActivity()).getIntent();
        estates = (Estates) intent.getSerializableExtra("estate");

        if (!estates.isOccupied()) {
            mButtonChat.setVisibility(View.GONE);
        }

        name = intent.getStringExtra("userName");
        userId = intent.getIntExtra("id", 0);

        buttonSetDueDate();

        buttonRate();

        buttonSetOwed();

        mButtonChat.setOnClickListener(v -> presenter.chatClicked());

        mButtonSend.setOnClickListener(v -> presenter.postEstateMessage(
               spinnerMessage, estates.getEstateid(), userId));

        mSpinner.setOnItemSelectedListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.postIdEstate(estates.getEstateid(), estates);
        presenter.getMessagesForAdapter(estates.getEstateid());
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
            if (!estates.isOccupied()) {
                showMessage("Can`t rate! No tenant!");
                return;
            }

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
            if (!estates.isOccupied()) {
                showMessage("Can`t set due date! No tenant!");
                return;
            }

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

    @Override
    public void buttonChat(int id) {
        Intent intent = new Intent(getActivity(), ChatActivity.class);
        intent.putExtra("recipient", userId);
        intent.putExtra("sender", id);
        startActivity(intent);
    }

    @Override
    public void showMessagesInAdapter(List<Messages> messages) {
        runOnUi(() -> {
            mAdapter.clear();
            mAdapter.addAll(messages);});
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
