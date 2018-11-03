package com.daredevil.landlordcommunication.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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

public class MyNotification extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        UserService userService = new HttpUserService(new HttpRepository(new OkHttpHttpRequester(), new GsonParser<>(User.class), new GsonParser<>(UserDTO.class)));
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);


        String text = intent.getStringExtra("user_name");
        final String[] notification = {""};

        new AsyncRunnerImpl().runInBackground(() -> {
            try {
                notification[0] = userService.getNotification(text);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!notification[0].equals("no notification") && !notification[0].equals("No user found.")) {
            Intent repeating_intent = new Intent(context, RepeatingActivity.class);
            repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            PendingIntent pendingIntent = PendingIntent.getActivity(context, 100,
                    repeating_intent, PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(android.R.drawable.arrow_up_float)
                    .setContentTitle("Hello Title")
                    .setContentText(notification[0])
                    .setAutoCancel(true);

            assert notificationManager != null;
            notificationManager.notify(100, builder.build());
        }

    }
}
