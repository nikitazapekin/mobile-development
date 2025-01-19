package com.example.lab9;

import java.util.ArrayList;
import java.util.List;

public class Watch {

    private int photo;
    private String brand;
    private String type;
    private double price;
    private int quantity;
    private String manufacturerDetails;

    public Watch( String brand, String type, double price, int quantity, String manufacturerDetails, int photo) {
        this.photo = photo;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.manufacturerDetails = manufacturerDetails;
    }

    public int getPhoto() {
        return photo;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getManufacturerDetails() {
        return manufacturerDetails;
    }

    private static List<Watch> watches = new ArrayList<>();

}
