package com.example.lab11fix;

public class Earthquake {
    private String id;
    private String place;
    private double magnitude;
    private long time;
    private String status;
    private String type;
    private String title;
    private double[] coordinates;

    // Getter and setter methods
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }

    public double getMagnitude() { return magnitude; }
    public void setMagnitude(double magnitude) { this.magnitude = magnitude; }

    public long getTime() { return time; }
    public void setTime(long time) { this.time = time; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double[] getCoordinates() { return coordinates; }
    public void setCoordinates(double[] coordinates) { this.coordinates = coordinates; }
}


/*
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
*/