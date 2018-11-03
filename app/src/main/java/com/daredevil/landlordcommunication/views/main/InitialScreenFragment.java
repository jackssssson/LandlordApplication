package com.daredevil.landlordcommunication.views.main;


import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.notification.MyNotification;
import com.daredevil.landlordcommunication.views.CreateUser.CreateUserActivity;
import com.daredevil.landlordcommunication.views.landlord.LandlordLogInActivity;
import com.daredevil.landlordcommunication.views.tenant.TenantLogInActivity;

import java.io.IOException;
import java.util.Calendar;
import java.util.Objects;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class InitialScreenFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.main.View {

    @BindView(R.id.user_name_plain)
    EditText userName;
    @BindView(R.id.password_plain)
    EditText password;

    @BindView(R.id.create_id)
    Button mCreate;

    @BindView(R.id.log_in_id)
    Button mLogIn;

    private Presenter presenter;
    private String user_name;

    @Inject
    public InitialScreenFragment() {
        // Required empty public constructor
    }


    @SuppressLint("StaticFieldLeak")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_initial_screen, container, false);

        ButterKnife.bind(this, view);

        if (!isLoggedIn()){
            setNotification(user_name);
        }

        mCreate.setOnClickListener(v -> startActivity(new Intent(getActivity(),
                CreateUserActivity.class)));


        mLogIn.setOnClickListener(v -> {
            try {
                presenter.logInUser(userName.getText().toString()
                        , password.getText().toString());
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
    public void logInUser(UserDTO user) {
        runOnUi(() -> {
            if (user.getUserName() == null) {
                Toast.makeText(getContext(), "Wrong user or password",
                        Toast.LENGTH_LONG).show();
            } else {
                if (user.getType().equals("Landlord")) {
                    Intent intent = new Intent(getActivity(), LandlordLogInActivity.class);
                    intent.putExtra("user", user);

                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getActivity(), TenantLogInActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void savePreference(String userName, String password) {
        SharedPreferences share = Objects.requireNonNull(getActivity()).getApplicationContext().
                getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = share.edit();

        editor.putString("user_name", userName);
        editor.putString("user_password", password);
        editor.apply();
    }

    @Override
    public void setNotification(String userNotification) {
        Calendar calendar = Calendar.getInstance();

        Intent intent = new Intent(getActivity(), MyNotification.class);
        intent.putExtra("user_name", userNotification);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(Objects.requireNonNull(getActivity())
                        .getApplicationContext(),
                100, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getActivity().
                getSystemService(DaggerAppCompatActivity.ALARM_SERVICE);

        Objects.requireNonNull(alarmManager).setRepeating(
                AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                60000, pendingIntent);

 }


    private void runOnUi(Runnable action) {
        Objects.requireNonNull(getActivity()).runOnUiThread(action);
    }

    private boolean isLoggedIn() {
        SharedPreferences share = Objects.requireNonNull(getActivity()).getApplicationContext().
                getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        String name = share.getString("user_name", "");
        String password = share.getString("user_password", "");
        user_name = name;

        return name.equals("") && password.equals("");
    }
}
