package com.daredevil.landlordcommunication.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.daredevil.landlordcommunication.async.AsyncRunnerImpl;
import com.daredevil.landlordcommunication.http.OkHttpHttpRequester;
import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.parser.GsonParser;
import com.daredevil.landlordcommunication.repositories.HttpRepository;
import com.daredevil.landlordcommunication.servieces.HttpUserService;
import com.daredevil.landlordcommunication.servieces.UserService;

import java.io.IOException;
import java.util.Objects;

public class MyNotification extends BroadcastReceiver {

    public static String NOTI_ID = "noti_id";
    public static String NOTI = "noti";
    private final UserService userService = new HttpUserService(new HttpRepository(new OkHttpHttpRequester(), new GsonParser<User>(User.class), new GsonParser<>(UserDTO.class)));

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = intent.getParcelableExtra(NOTI);
        SharedPreferences share = Objects.requireNonNull(context).getApplicationContext().
                getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        final boolean[] check = {true};
        new AsyncRunnerImpl().runInBackground(() -> {
            try {
                check[0] = !userService.getNotification(share.getString("user_name", "")).equals("no notification");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        if(check[0]) {
            int id = intent.getIntExtra(NOTI_ID, 0);
            Objects.requireNonNull(notificationManager).notify(id, notification);
        }

    }


}
