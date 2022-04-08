package com.example.bg_tasks;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("users?access-token=88fd6d644cc96d508867db023178aa79dc166ebab06cef2aa12855342a566aba")
    Call<ArrayList<User>> getAllUsers();

    @GET("users/{id}?access-token=88fd6d644cc96d508867db023178aa79dc166ebab06cef2aa12855342a566aba")
    Call<User> getUsersByID(@Path("id") int id);


    @DELETE("users/{id}?access-token=88fd6d644cc96d508867db023178aa79dc166ebab06cef2aa12855342a566aba")
    Call<ArrayList<User>> deleteUserByID(@Path("id") int id);

    @PUT("users/{id}?access-token=88fd6d644cc96d508867db023178aa79dc166ebab06cef2aa12855342a566aba")
    Call<User> updateUserByID(@Body() User user, @Path("id") int id);
}
