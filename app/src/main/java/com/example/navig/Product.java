

 package com.example.navig;

public class Product {
    private int imageResId;
    private String name;
    private double price;
    public Product(int imageResId, String name, double price) {
        this.imageResId = imageResId;
        this.name = name;
        this.price = price;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

