package com.daredevil.landlordcommunication.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
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
import com.daredevil.landlordcommunication.views.main.InitialScreenActivity;

import java.io.IOException;
import java.util.Objects;

public class MyNotification extends BroadcastReceiver {

    public static String NOTI_ID = "noti_id";
    public static String NOTI = "noti";
    private static final String CHANEL_ID="Notification-1";
    private final UserService userService = new HttpUserService(new HttpRepository(new OkHttpHttpRequester(), new GsonParser<User>(User.class), new GsonParser<>(UserDTO.class)));

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent onClickIntent = new Intent(context, InitialScreenActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntentWithParentStack(onClickIntent);
        PendingIntent onClickPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            builder = new Notification.Builder((context), CHANEL_ID);
        } else {
            builder=new Notification.Builder(context);
        }
        builder.setContentTitle("Landlord Communication:");
        builder.setSmallIcon(android.R.drawable.arrow_up_float);
        builder.setContentIntent(onClickPendingIntent);



        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        SharedPreferences share = Objects.requireNonNull(context).getApplicationContext().
                getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String[] str=new String[1];
        boolean[] isFinished=new boolean[1];
        isFinished[0]=true;
        new AsyncRunnerImpl().runInBackground(() -> {
            try {
                str[0]=userService.getNotification(share.getString("user_name", ""));
            } catch (IOException e) {
                e.printStackTrace();
            }
            isFinished[0]=false;
        });
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(isFinished[0]==false)
            return;
        builder.setContentText(str[0]);
        Notification notification=builder.build();


        if(!str[0].equals("no notification")) {
            int id = intent.getIntExtra(NOTI_ID, 0);
            Objects.requireNonNull(notificationManager).notify(id, notification);
        }

    }


}
