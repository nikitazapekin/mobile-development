package com.example.lab10;




import com.google.gson. annotations . Expose;
import com.google.gson. annotations .SerializedName;

public class Post {

    @SerializedName("userId")
    @Expose
    private int userId;

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("body")
    @Expose

    private String body;


    public int getUserId() {
        return userId;

    }


    public void setUserId(int userId) {
        this.userId = userId;

    }


}
/*
public class Post {
}
*/