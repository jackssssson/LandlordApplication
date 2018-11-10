package com.daredevil.landlordcommunication.views.tenant;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.ListView;
import android.widget.TextView;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.views.tenant.info.TenantInfoActivity;
import com.daredevil.landlordcommunication.views.tenant.unoccupiedestates.TenantUnOccupiedActivity;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TenantLogInFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.tenant.View, AdapterView.OnItemClickListener {

    @BindView(R.id.user_name_log_in)
    TextView mUserName;

    @BindView(R.id.user_email_log_tenant)
    TextView mUserEmail;

    @BindView(R.id.user_rating_log_in)
    TextView mUserRating;

    @BindView(R.id.user_total_owed_tenant)
    TextView mUserTotalOwed;

    @BindView(R.id.btn_create_estate_log_in)
    Button mButtonRent;

    @BindView(R.id.lv_estate_log_in)
    ListView mListView;

    @BindView(R.id.btn_log_out_tenant)
    Button mLogoutButton;

    private ArrayAdapter<Estates> mAdapter;
    private Presenter presenter;
    private UserDTO userDTO;

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

        instantiateAdapter();

        Intent intent2 = Objects.requireNonNull(getActivity()).getIntent();
        userDTO = (UserDTO) intent2.getSerializableExtra("user");

        mListView.setAdapter(mAdapter);

        showEstateAdapter();

        setupLogoutButton();
        presenter.setUser(userDTO);

        mListView.setOnItemClickListener(this);

        mButtonRent.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), TenantUnOccupiedActivity.class);
            intent.putExtra("id", userDTO.getUserid());

            startActivity(intent);
        });

        return  view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadUser();
        presenter.refreshUserDto(userDTO.getUserid());
    }

    private void setupLogoutButton(){
        mLogoutButton.setOnClickListener(i-> presenter.logOut());
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showUserInfo(String name, String email, String rating, float sum) {
        runOnUi(() -> {
            mUserName.setText(name);
            mUserEmail.setText(email);
            mUserRating.setText(rating);
            mUserTotalOwed.setText(String.valueOf(sum));
        });
    }

    @Override
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public void showEstateAdapter() {
       runOnUi(() -> {

           mAdapter.clear();

           for (Estates e : userDTO.getEstates()) {
               mAdapter.add(e);
           }
       });
    }

    private void runOnUi(Runnable action) {
        Objects.requireNonNull(getActivity()).runOnUiThread(action);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), TenantInfoActivity.class);
        intent.putExtra("estate", mAdapter.getItem(position));
        intent.putExtra("userName", userDTO.getUserName());
        intent.putExtra("tenantId", userDTO.getUserid());
        startActivity(intent);
    }

    private void instantiateAdapter(){
        mAdapter = new ArrayAdapter<Estates>(Objects.requireNonNull(getContext()),
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

    @Override
    public void setSharedPreferencesToNull(){
        SharedPreferences share = Objects.requireNonNull(getActivity()).getApplicationContext().
                getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = share.edit();

        editor.putString("user_name", "");
        editor.putString("user_password", "");
        editor.apply();
    }

    @Override
    public void finish() {
        Objects.requireNonNull(getActivity()).finish();
    }
}
