package com.daredevil.landlordcommunication.http;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpHttpRequester implements HttpRequester {

    public OkHttpHttpRequester() {
    }

    @Override
    public String getUser(String url) throws IOException {
        Request request = new Request
                .Builder()
                .get()
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();

        String body = response.body().string();
        return body;

    }

    @Override
    public String postUser(String url, String body) throws IOException {
        RequestBody requestBody = RequestBody.create(
                MediaType.get("application/json"), body);

        Request request = new Request
                .Builder()
                .post(requestBody)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    @Override
    public String getUserLogIn(String url) throws IOException {
        Request request = new Request
                .Builder()
                .get()
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();

        String body = response.body().string();


        return body;

    }


}
