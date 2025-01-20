package com.example.lab12test;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Human {

    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    @ColumnInfo(name = "last_name")
    public String lastName;
 //   public Date birthday;
    public String phone;

    public String age;

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


    public String getLastName() {
        return lastName;
    }
    public void setLastName(String name) {
        this.lastName = name;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}