package com.example.lab11fix;



import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MarvelResponse<T> {
    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private MarvelDataContainer<T> data;

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public MarvelDataContainer<T> getData() {
        return data;
    }
}

class MarvelDataContainer<T> {
    @SerializedName("offset")
    private int offset;
    @SerializedName("limit")
    private int limit;
    @SerializedName("total")
    private int total;
    @SerializedName("count")
    private int count;
    @SerializedName("results")
    private List<T> results;

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public List<T> getResults() {
        return results;
    }
}

class Event {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;



    @SerializedName("start")
    private String start;

    @SerializedName("end")
    private String end;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStart() {
        return start;
    }
    public String getEnd() {
        return end;
    }
}
