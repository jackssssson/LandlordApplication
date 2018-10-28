package com.daredevil.landlordcommunication;



import com.daredevil.landlordcommunication.diconfig.DaggerAppComponent;
import com.daredevil.landlordcommunication.views.chat.Constants;

import java.net.URISyntaxException;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.socket.client.IO;
import io.socket.client.Socket;

public class LandlordApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
      return DaggerAppComponent.builder().application(this).build();
    }

    private Socket mSocket;
    {
        try {
            mSocket = IO.socket(Constants.CHAT_SERVER_URL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return mSocket;
    }
}
