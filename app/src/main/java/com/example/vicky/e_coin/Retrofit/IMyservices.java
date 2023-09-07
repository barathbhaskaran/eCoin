package com.example.vicky.e_coin.Retrofit;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Observable;

public interface IMyservices {
    @POST("register")
    @FormUrlEncoded
    io.reactivex.Observable <String> registerUser(@Field("email") String email,
                                         @Field("name") String name,
                                         @Field("password") String password);

    @POST("login")
    @FormUrlEncoded
    io.reactivex.Observable <String> loginUser(@Field("email") String email,
                                         @Field("password") String password);
}
