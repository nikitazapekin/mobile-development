package com.example.lab12test;


import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(
        entity = Human.class,
        parentColumns = "id",
        childColumns = "human_id",
        onDelete = CASCADE
))
public class Horse {

    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public Integer age;

    @ColumnInfo(name = "human_id")
    public long humanId;

    public long getHumanId() {
        return humanId;
    }

    public void setHumanId(long customerId) {
        this.humanId = humanId;
    }



    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}