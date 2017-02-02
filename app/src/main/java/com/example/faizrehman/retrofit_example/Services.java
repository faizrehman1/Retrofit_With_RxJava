package com.example.faizrehman.retrofit_example;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by faizrehman on 01/02/2017.
 */

public interface Services {
    @GET("users/")
    Call<List<UserModel>> usermodels();

    Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    //for single index of user

    @GET("users/{user}")
    Call<UserModel> singleUser(int user);

    Retrofit getRetrofit = new Retrofit.Builder().baseUrl(Urls.Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
