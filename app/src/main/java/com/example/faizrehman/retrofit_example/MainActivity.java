package com.example.faizrehman.retrofit_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.faizrehman.retrofit_example.Connection.Services;
import com.example.faizrehman.retrofit_example.Models.UserModel;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Hello";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Services interfacess = Services.retrofit.create(Services.class);
       // with Java

//        Call<List<UserModel>> usermodels = interfacess.usermodels();
//        usermodels.enqueue(new Callback<List<UserModel>>() {
//            @Override
//            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
//                if (response.isSuccessful()) {
//                    for (int i = 0; i < response.body().size(); i++) {
//                        Log.d("TAG", response.body().get(i).toString());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<UserModel>> call, Throwable t) {
//
//            }
//        });


        //with RxJava
        Observable<List<UserModel>> userModelObservable = interfacess.getUser();
       userModelObservable.subscribeOn(Schedulers.newThread())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<List<UserModel>>() {
                              @Override
                              public void onCompleted() {

                              }

                              @Override
                              public void onError(Throwable e) {

                              }

                              @Override
                              public void onNext(List<UserModel> userModels) {
                                    Log.d("TAG: FAiz",userModels.toString());

                              }
                          });
                       //for Single index of user
//                       Services singleinterface = Services.getRetrofit.create(Services.class);
//       //
//        Call<UserModel> userModelCall = singleinterface.singleUser(2);
//        userModelCall.enqueue(new Callback<UserModel>() {
//            @Override
//            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
//                if(response.isSuccessful()){
//                    Log.e("TAG", response.body().getEmail());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<UserModel> call, Throwable t) {
//
//            }
//        });


    }
}
