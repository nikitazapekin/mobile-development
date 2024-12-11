package com.example.lab12test;



import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


@Database(entities = {   Human.class, Horse.class}, version = 6)

public abstract class AppDatabase extends RoomDatabase {





    public abstract HumanDao humanDao();
    public abstract  HorseDao horseDao();
}