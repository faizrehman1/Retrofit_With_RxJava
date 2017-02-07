package com.example.faizrehman.retrofit_example.Connection;

import com.example.faizrehman.retrofit_example.Constants.Urls;
import com.example.faizrehman.retrofit_example.Models.UserModel;
import com.example.faizrehman.retrofit_example.Models.UserPostModels;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by faizrehman on 01/02/2017.
 */

public interface Services {
    @GET("users/")
  //  Call<List<UserModel>> usermodels();
  Observable<List<UserModel>> getUser();
    Retrofit retrofit = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Urls.Base_url)
            .build();


    //for single index of user

    @GET("users/{user}")
 //   Call<UserModel> singleUser(int user);
    Observable<UserModel> user(@Path("id") int id);
    Retrofit getRetrofit = new Retrofit.Builder().baseUrl(Urls.Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();



  @POST("posts")
  Call<UserPostModels> userpost(@Body UserPostModels userPostRequest);
  Retrofit retrofitPost = new Retrofit.Builder()
          .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .baseUrl(Urls.Base_url)
          .build();


}
