package com.example.lab12test;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "horse", foreignKeys = @ForeignKey(entity = Human.class,
        parentColumns = "id", childColumns = "owner_id", onDelete = ForeignKey.CASCADE))
public class Horse {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private int age;
    private long owner_id;

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

    public long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(long owner_id) {
        this.owner_id = owner_id;
    }
}
