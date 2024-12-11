package com.example.lab12test;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

//@Entity(tableName = "human")
@Entity(tableName = "human")
public class Human {

    @PrimaryKey(autoGenerate = true)
    public long id;
  public String name;
    public int age;
    public String phone;

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
