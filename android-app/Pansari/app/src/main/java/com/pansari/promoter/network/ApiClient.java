package com.pansari.promoter.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


//https://pansari-promoter-api-dot-pansari-promoter-app.appspot.com
        //https://pansari-promoter-app.appspot.com
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pansari-promoter-api-dot-pansari-promoter-app.appspot.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        return retrofit;
    }
}
