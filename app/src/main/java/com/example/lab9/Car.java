package com.example.lab9;


import java.util.ArrayList;
import java.util.List;

public class Car {

    private String name;
    private byte price;
    private String description;
    private String fullDescription;
    private int logo;



    public Car(String name, byte price, String description, String fullDescription,  int logo) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.fullDescription = fullDescription;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public byte getPrice() {
        return price;
    }

    public String getDescribtion() {
        return description;
    }

    public String getFullDescribtion() {
        return fullDescription;
    }

    public int getLogo() {
        return logo;
    }

    private static List<Car> cars = new ArrayList<>();

}
