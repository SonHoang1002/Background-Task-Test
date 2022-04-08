package com.example.bg_tasks;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("users")
    Call<ArrayList<User>> getAllUsers();

    @GET("users/{id}")
    Call<User> getUsersByID(@Path("id") int id);

    @GET("users/{id}")
    Call<User> updateUserByID(@Path("id") int id);

    @DELETE("/public/v2/users/{id}")
    Call<ArrayList<User>> deleteUserByID(@Path("id") int id);
}
