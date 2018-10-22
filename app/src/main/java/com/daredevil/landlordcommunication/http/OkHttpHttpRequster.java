package com.daredevil.landlordcommunication.http;

import com.daredevil.landlordcommunication.constants.Constants;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHttpRequster implements HttpUserRequester {

    public OkHttpHttpRequster() {
    }

    @Override
    public String get(String url) throws IOException {
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

//    @Override
//    public String post(String url, String body) throws IOException {
//        RequestBody requestBody = RequestBody.create(
//                MediaType.get("application/json"), body);
//
//        Request request = new Request
//                .Builder()
//                .post(requestBody)
//                .url(url)
//                .build();
//        OkHttpClient client = new OkHttpClient();
//
//        Response response = client.newCall(request).execute();
//
//        return response.body().string();
//    }
//
//    @Override
//    public String delete(String url) throws IOException {
//        Request request = new Request
//                .Builder()
//                .delete()
//                .url(url)
//                .build();
//        OkHttpClient client = new OkHttpClient();
//
//        Response response = client.newCall(request).execute();
//        return response.body().string();
//    }
//
//    @Override
//    public String put(String url, String body) throws IOException {
//        RequestBody requestBody = RequestBody.create(MediaType.get("application/json"), body);
//
//        Request request = new Request
//                .Builder()
//                .put(requestBody)
//                .url(url)
//                .build();
//        OkHttpClient client = new OkHttpClient();
//        Response response = client.newCall(request).execute();
//        return response.body().string();
//    }
}
