package com.daredevil.landlordcommunication.http;

import java.io.IOException;
import java.util.Objects;

import javax.inject.Inject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpHttpRequester implements HttpRequester {

    @Inject
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

        return Objects.requireNonNull(response.body()).string();

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

        return Objects.requireNonNull(response.body()).string();
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


        return Objects.requireNonNull(response.body()).string();

    }

    @Override
    public String postText(String url) throws IOException {
        RequestBody requestBody = RequestBody.create(
                MediaType.get("application/json"), "");

        Request request = new Request
                .Builder()
                .put(requestBody)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();

        return Objects.requireNonNull(response.body()).string();
    }

}
