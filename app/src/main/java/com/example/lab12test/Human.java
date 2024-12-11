package com.example.lab12test;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "human")
public class Human {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private int age;
    private String phone;

    // Геттеры и сеттеры
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
