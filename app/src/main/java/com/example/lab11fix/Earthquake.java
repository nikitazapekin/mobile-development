package com.example.lab11fix;

public class Earthquake {
    private String id;
    private String place;
    private double magnitude;
    private long time;


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }
    public double getMagnitude() { return magnitude; }
    public void setMagnitude(double magnitude) { this.magnitude = magnitude; }
    public long getTime() { return time; }
    public void setTime(long time) { this.time = time; }
}
