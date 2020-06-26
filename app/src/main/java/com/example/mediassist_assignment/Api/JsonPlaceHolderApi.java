package com.example.mediassist_assignment.Api;

import com.example.mediassist_assignment.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("users")
    Call<Example> getData(@Query("access-token") String accessToken);
}
