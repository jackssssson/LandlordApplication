package com.daredevil.landlordcommunication.views.CreateUser;


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
import android.widget.Toast;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.views.main.InitialScreenActivity;

import java.io.IOException;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateUserFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.CreateUser.View {

    @BindView(R.id.rg_button)
    RadioGroup mRadioGroup;

    @BindView(R.id.user_name_plain)
    EditText mUserName;

    @BindView(R.id.user_password_plain)
    EditText mUserPassword;

    @BindView(R.id.user_email_plain)
    EditText mUserEmail;

    @BindView(R.id.user_iBan_plain)
    EditText mUserIBan;

    @BindView(R.id.btn_create)
    Button mButtonCreate;


    private Presenter presenter;

    @Inject
    public CreateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_user, container, false);

        ButterKnife.bind(this, view);

        mButtonCreate.setOnClickListener((View v) -> {
            UserDTO userDTO = new UserDTO(mUserName.getText().toString(),
                    mUserPassword.getText().toString(),
                    mUserEmail.getText().toString(), mUserIBan.getText().toString());

            int radioButtonId = mRadioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = mRadioGroup.findViewById(radioButtonId);
            String text;

            if (radioButton == null){
                text = "";
            } else {
                text = radioButton.getText().toString();
            }

            try {
                presenter.createUserDTO(userDTO, text);
            } catch (IOException e) {
                e.printStackTrace();
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
    public void createUserDTO(String isCreated) {
        runOnUi(() -> {
            if (isCreated.equals("Tenant created.") || isCreated.equals("Landlord created.")) {
                startActivity(new Intent(getActivity(), InitialScreenActivity.class));
            } else {
                Toast.makeText(getContext(), isCreated,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void typeWarning() {
        runOnUi(() -> Toast.makeText(getContext(),
                "Choose landlord or tenant!", Toast.LENGTH_LONG).show());
    }

    private void runOnUi(Runnable action) {
        Objects.requireNonNull(getActivity()).runOnUiThread(action);
    }
}
