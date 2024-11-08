package com.example.lab10;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface JSONPlaceholderApi {

    @GET("/posts/{id}")
    Call<Post> getPostWithID(@Path("id") int id);

    @GET("/todos/{id}")
    Call<Todo> getTodoWithID(@Path("id") int id);



    @GET("/posts")
    Call<List<Post>> getPosts(@Query("_page") int page, @Query("_limit") int limit);
}
