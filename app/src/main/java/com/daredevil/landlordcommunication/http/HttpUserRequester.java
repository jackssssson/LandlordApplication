package com.daredevil.landlordcommunication.http;

import java.io.IOException;

public interface HttpUserRequester {
    String get(String url) throws IOException;
    String post(String url, String body) throws IOException;
    String delete(String url) throws IOException;
    String put(String url, String body) throws IOException;
}
