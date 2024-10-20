package com.example.lab8;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String name;
    private byte price;
    private String describtion;


    public Car(String name, byte price, String describtion) {
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


    private static List<Car> cars = new ArrayList<>();
    public static  List<Car> getCars() {
        cars.add(new Car("Car 1 ", (byte) 32, "ddd"));
        cars.add(new Car("Car 2", (byte) 32, "ddd"));
        cars.add(new Car("Car 3", (byte) 32, "ddd"));
        return  cars;
    }
}
