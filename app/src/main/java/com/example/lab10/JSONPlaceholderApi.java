package com.example.lab10;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface JSONPlaceholderApi {


    @GET("/posts/{id}")

    public Call<Post> getPostwithID(@Path("id") int id);

    Call<Post> getPostWithID(int i);
}