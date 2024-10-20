package com.example.lab8;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String name;
    private byte price;
    private String description;
    private String fullDescription;
    private int logo;  // Изменено на int для хранения идентификатора ресурса

    public Car(String name, byte price, String description, int logo) {
        this.name = name;
        this.price = price;
        this.description = description;
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

    public int getLogo() {
        return logo;  // Возвращаем идентификатор ресурса
    }

    private static List<Car> cars = new ArrayList<>();

    public static List<Car> getCars() {
        cars.add(new Car("Car 1", (byte) 100, "Хорошая и компактная", R.drawable.car));

        cars.add(new Car("Car 3", (byte) 112, "Недорогая", R.drawable.sedan));
        return cars;
    }
}

/*
package com.example.lab8;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String name;
    private byte price;
    private String describtion;
 private String fullDescribtion;

private String logo;

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
        cars.add(new Car("Car 1 ", (byte) 100, "Хорошая и компактная"));
        cars.add(new Car("Car 2", (byte) 142, "Европейское производство"));
        cars.add(new Car("Car 3", (byte) 112, "Недорогая"));
        return  cars;
    }
}
*/
