package com.daredevil.landlordcommunication.http;

import java.io.IOException;

public interface HttpRequester {
    String getUser(String url) throws IOException;

    String postUser(String url, String body) throws IOException;

    String getUserLogIn(String url) throws IOException;

    String postText(String url) throws IOException;
}
