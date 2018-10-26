package com.daredevil.landlordcommunication.views.main;

import java.io.IOException;

public interface Presenter {
    void setView(View view);

    void logInUser(String userName, String password) throws IOException;
}
