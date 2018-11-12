package com.daredevil.landlordcommunication.views.main;


import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
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

    @BindView(R.id.rl_initial)
    RelativeLayout mRelativeLayout;

    @BindView(R.id.pb_initial)
    ProgressBar mProgressBar;

    private Presenter presenter;
    private String shared_user_name;
    private String shared_password;

    private static final String CHANEL_ID="Notification-1";

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


        showLoading();
        if (isLoggedIn()){

            try {
                presenter.logInUser(shared_user_name, shared_password);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            hideLoading();

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
        if(!isLoggedIn()) {
            cancelNotifications();
            hideLoading();
        }
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
                savePreference("", "");
                hideLoading();
                cancelNotifications();

            } else {
                if (user.getType().equals("Landlord")) {
                    Intent intent = new Intent(getActivity(), LandlordLogInActivity.class);
                    intent.putExtra("user", user);
                    presenter.showNotification(shared_user_name);

                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getActivity(), TenantLogInActivity.class);
                    intent.putExtra("user", user);
                    presenter.showNotification(shared_user_name);
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
    public void setNotification(String userNotification){
        createNotificationChannel();

        Intent notiIntent=new Intent(getActivity(), MyNotification.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getActivity(),
                0, notiIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar calendar = Calendar.getInstance();

        AlarmManager alarmManager = (AlarmManager) Objects.requireNonNull(getActivity()).
                getSystemService(DaggerAppCompatActivity.ALARM_SERVICE);

        Objects.requireNonNull(alarmManager).setRepeating(
                AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                60000, pendingIntent);


    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name="Notification-1 channel";
            String description="Notification-1 channel's description";
            int importance= NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel=new NotificationChannel(CHANEL_ID, name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager=(NotificationManager) Objects.requireNonNull(getActivity())
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            Objects.requireNonNull(notificationManager)
                    .createNotificationChannel(notificationChannel);
        }
    }


    private void runOnUi(Runnable action) {
        if(getActivity()==null)
            return;
        getActivity().runOnUiThread(action);
    }

    private boolean isLoggedIn() {
        SharedPreferences share = Objects.requireNonNull(getActivity()).getApplicationContext().
                getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        String name = share.getString("user_name", "");
        String password = share.getString("user_password", "");
        shared_user_name = name;
        shared_password=password;

        return !(name.equals("") && password.equals(""));
    }

    private void cancelNotifications(){
        AlarmManager alarmManager = (AlarmManager) Objects.requireNonNull(getActivity()).
                getSystemService(DaggerAppCompatActivity.ALARM_SERVICE);

        Intent notiIntent=new Intent(getActivity(), MyNotification.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getActivity(),
                0, notiIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.cancel(pendingIntent);
    }

    private void showLoading(){
        mProgressBar.setVisibility(View.VISIBLE);
        mRelativeLayout.setVisibility(View.GONE);
    }

    private void hideLoading(){
        mProgressBar.setVisibility(View.GONE);
        mRelativeLayout.setVisibility(View.VISIBLE);
    }

}
