package com.daredevil.landlordcommunication.views.AddUser;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.constants.Constants;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AddUserActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        AddUserFragment fragment = new AddUserFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_Fragment, fragment)
                .commit();

        OkHttpClient client = new OkHttpClient();
        String url = Constants.getLandlord;
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();


        new AsyncTask<Boolean, Void, Void>(){

            @Override
            protected Void doInBackground(Boolean... booleans) {
                try {
                   Response response = client.newCall(request).execute();
                   String body = response.body().string();
                   int a = 5;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }.execute(true);
    }
}
