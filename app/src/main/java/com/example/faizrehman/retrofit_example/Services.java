package com.example.faizrehman.retrofit_example;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by faizrehman on 01/02/2017.
 */

public interface Services {
    @GET("users/")
  //  Call<List<UserModel>> usermodels();
  Observable<UserModel> getUser();
    Retrofit retrofit = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Urls.Base_url)
            .build();


    //for single index of user

    @GET("users/{user}")
    Call<UserModel> singleUser(int user);

    Retrofit getRetrofit = new Retrofit.Builder().baseUrl(Urls.Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
