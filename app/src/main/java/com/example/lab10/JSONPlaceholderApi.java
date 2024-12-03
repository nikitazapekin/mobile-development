package com.example.lab10;



import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface JSONPlaceholderApi {


//dvvdsv





    @GET
    Call<ResponseBody> getImage(@Url String url);


    @GET
    Call<Photo> getPhoto(@Url String url);

    @GET("/comments/{id}")
    Call<Comment> getCommentWithID(@Path("id") int id);

    @GET("comments")
    Call<List<Comment>> getComments();
}
