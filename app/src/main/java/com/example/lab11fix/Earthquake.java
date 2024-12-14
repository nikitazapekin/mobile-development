package com.example.lab11fix;

public class Earthquake {
    private String id;
    private Properties properties;

    public String getId() {
        return id;
    }

    public Properties getProperties() {
        return properties;
    }

    public static class Properties {
        private double mag;
        private String place;
        private long time;
        private String status;
        private String title;
        private String alert;
        private Double cdi;
        private Double mmi;

        // Геттеры
        public double getMag() {
            return mag;
        }

        public String getPlace() {
            return place;
        }

        public long getTime() {
            return time;
        }

        public String getStatus() {
            return status;
        }

        public String getTitle() {
            return title;
        }

        public String getAlert() {
            return alert;
        }

        public Double getCdi() {
            return cdi;
        }

        public Double getMmi() {
            return mmi;
        }
    }
}

/*
package com.example.lab11fix;

import com.google.gson.annotations.SerializedName;

public class Earthquake {
    private double mag;
    private String place;
    private long time;
    private String status;
    private String type;
    private String title;

    @SerializedName("properties")
    private Properties properties;

    public double getMag() { return mag; }
    public void setMag(double mag) { this.mag = mag; }

    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }

    public long getTime() { return time; }
    public void setTime(long time) { this.time = time; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Properties getProperties() { return properties; }
    public void setProperties(Properties properties) { this.properties = properties; }

    public static class Properties {
        private String url;
        private String alert;
        private double cdi;
        private double mmi;

        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }

        public String getAlert() { return alert; }
        public void setAlert(String alert) { this.alert = alert; }

        public double getCdi() { return cdi; }
        public void setCdi(double cdi) { this.cdi = cdi; }

        public double getMmi() { return mmi; }
        public void setMmi(double mmi) { this.mmi = mmi; }
    }
}
*/
 /*
package com.example.lab11fix;

import com.google.gson.annotations.SerializedName;

public class Earthquake {
    private String id;
    private String place;
    private double magnitude;
    private long time;
    private String status;
    private String type;
    private String title;
    private double[] coordinates;

    @SerializedName("properties")
    private Properties properties;

    // Геттеры и сеттеры
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

    public Properties getProperties() { return properties; }
    public void setProperties(Properties properties) { this.properties = properties; }

    // Вложенный класс для properties
    public static class Properties {
        private String url;

        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
    }
}
*/
