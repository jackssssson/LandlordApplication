package com.daredevil.landlordcommunication.views.main;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.async.AsyncRunnerImpl;
import com.daredevil.landlordcommunication.constants.Constants;
import com.daredevil.landlordcommunication.http.HttpUserRequester;
import com.daredevil.landlordcommunication.http.OkHttpHttpRequster;
import com.daredevil.landlordcommunication.models.Landlord;
import com.daredevil.landlordcommunication.models.User;
import com.daredevil.landlordcommunication.parser.GsonParser;
import com.daredevil.landlordcommunication.parser.JsonParserContract;
import com.daredevil.landlordcommunication.views.CreateUser.CreateUserActivity;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mCreate = findViewById(R.id.create_id);
        Button mLogIn = findViewById(R.id.log_in_id);

        getUser();

        postLandlord();

        mCreate.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,
                CreateUserActivity.class)));

        mLogIn.setOnClickListener(item -> startActivity(new Intent(MainActivity.this,
                CreateUserActivity.class)));

    }

    private void postLandlord() {
        // String userName, String userPassword, String userEmail,
        // String city, String country, String street, int flat, int streetNumber,
        // int floor, char entance, float price, String estateName

        AsyncRunner asyncRunner = new AsyncRunnerImpl();
        asyncRunner.runInBackground(() -> {
            String url = Constants.postLandlord;
            Landlord user = new Landlord("Jivo", "123", "12", "Tervel", "Bulgaristan",
                    "Zaharii Zograf", 1, 29, 1, 'a', 72978, "Jivkos flat");

            HttpUserRequester httpUserRequester = new OkHttpHttpRequster();


            JsonParserContract<Landlord> parser = new GsonParser<>(Landlord.class, Landlord[].class);
            String body = parser.toJson(user);
            try {
                httpUserRequester.post(url, body);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


    }

    private void getUser() {
        String url = Constants.getUser;

        AsyncRunnerImpl asyncRunner = new AsyncRunnerImpl();
        asyncRunner.runInBackground(() -> {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .get()
                    .url(url)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                String usersJson = Objects.requireNonNull(response.body()).string();
                Gson gson = new Gson();
                User user = gson.fromJson(usersJson, User.class);
                System.out.println(user);
                int a = 5;
                System.out.println(a);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
