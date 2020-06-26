package com.example.mediassist_assignment.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://gorest.co.in/public-api/";

    public static JsonPlaceHolderApi getService() {

        if(retrofit == null){
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder okHttpClient =new  OkHttpClient.Builder();
            okHttpClient.addInterceptor(httpLoggingInterceptor);

            retrofit = new Retrofit
                    .Builder().client(okHttpClient.build())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(JsonPlaceHolderApi.class);
    }
}
