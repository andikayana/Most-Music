package com.blikadek.popularmusic.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by M13x5aY on 15/08/2017.
 */

public class ApiClient {
    private static final String BASE_URL = "http://ws.audioscrobbler.com/";
    private static Retrofit mRetrofit;

    public static Retrofit getRetrofitClient(){
        if (mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit;
    }
}
