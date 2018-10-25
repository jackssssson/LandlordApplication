package com.daredevil.landlordcommunication.views.main;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.views.CreateUser.CreateUserActivity;
import com.daredevil.landlordcommunication.views.landlord.LogInLandlord;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


public class InitialScreenActivity extends DaggerAppCompatActivity implements Navigator{

    @Inject
    InitialScreenFragment mMainFragment;

    @Inject
    InitialScreenPresenter mPresenter;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_screen);

        mMainFragment.setPresenter(mPresenter);
        mMainFragment.setNavigator(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, mMainFragment)
                .commit();
    }

    @Override
    public void navigateCreateButton() {
        startActivity(new Intent(this, CreateUserActivity.class));
    }

    @Override
    public void navigateLogInButton() {
        startActivity(new Intent(this, LogInLandlord.class));
    }


//    private void postLandlord() {
//        // String userName, String userPassword, String userEmail,
//        // String city, String country, String street, int flat, int streetNumber,
//        // int floor, char entance, float price, String estateName
//
//       AsyncRunner.runInBackGround(() -> {
//            String url = Constants.postLandlord;
//            Landlord user = new Landlord("Jivo", "123", "12", "Tervel", "Bulgaristan",
//                    "Zaharii Zograf", 1, 29, 1, 'a', 72978, "Jivkos flat");
//
//            HttpRequester httpUserRequester = new OkHttpHttpRequester();
//
//
//            JsonParser<Landlord> parser = new GsonParser<>(Landlord.class, Landlord[].class);
//            String body = parser.toJson(user);
//            try {
//                httpUserRequester.post(url, body);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        });
//
//
//    }
//
//    private void getUser() {
//        String url = Constants.getUser;
//
//       AsyncRunner.runInBackGround(() -> {
//            OkHttpClient client = new OkHttpClient();
//            Request request = new Request.Builder()
//                    .get()
//                    .url(url)
//                    .build();
//
//            try {
//                Response response = client.newCall(request).execute();
//                String usersJson = Objects.requireNonNull(response.body()).string();
//                Gson gson = new Gson();
//                User user = gson.fromJson(usersJson, User.class);
//                System.out.println(user);
//                int a = 5;
//                System.out.println(a);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//    }
}
