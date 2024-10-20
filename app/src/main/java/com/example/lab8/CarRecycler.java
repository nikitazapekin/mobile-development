package com.example.lab8;

import java.util.ArrayList;
import java.util.List;

public class CarRecycler {

    private String name;
    private byte price;
    private String describtion;




    public CarRecycler(String name, byte price, String describtion) {
        this.name = name;
        this.price = price;
        this.describtion = describtion;
    }
    public String getName() {
        return  name;

    }
    public  byte getPrice()
    {
        return price;
    }
    public String getDescribtion() {
        return  describtion;
    }


    private static List<CarRecycler> cars = new ArrayList<>();
    public static  List<CarRecycler> getCars() {
        cars.add(new CarRecycler("Car 1 ", (byte) 100, "Хорошая и компактная"));
        cars.add(new CarRecycler("Car 2", (byte) 142, "Европейское производство"));
        cars.add(new CarRecycler("Car 3", (byte) 112, "Недорогая"));
        return  cars;
    }
}
