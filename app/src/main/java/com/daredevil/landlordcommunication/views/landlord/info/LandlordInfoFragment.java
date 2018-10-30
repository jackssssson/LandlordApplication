package com.daredevil.landlordcommunication.views.landlord.info;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.daredevil.landlordcommunication.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandlordInfoFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.landlord.info.View{

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

    @BindView(R.id.rate_info)
    EditText mRateTenant;

    @BindView(R.id.owed_info)
    EditText mOwedInfo;

    @BindView(R.id.user_set_due_date)
    EditText setDueDate;

    @BindView(R.id.btn_owed)
    Button mButtonOwedInfo;

    @BindView(R.id.btn_rate_info)
    Button mButtonRate;

    @BindView(R.id.btn_set_info)
    Button mButtonSet;

    @BindView(R.id.btn_chat_info)
    Button mButtonChat;

    private Presenter presenter;

    @Inject
    public LandlordInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_landlord_info, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
