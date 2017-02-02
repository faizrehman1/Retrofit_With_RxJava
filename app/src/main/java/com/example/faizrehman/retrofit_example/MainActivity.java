package com.example.faizrehman.retrofit_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
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
        Observable<UserModel> userModelObservable = interfacess.getUser();
       userModelObservable.subscribeOn(Schedulers.newThread())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<UserModel>() {
                              @Override
                              public void onCompleted() {

                              }

                              @Override
                              public void onError(Throwable e) {

                              }

                              @Override
                              public void onNext(UserModel userModel) {
                                  Log.d("TAG",userModel.getEmail());
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
