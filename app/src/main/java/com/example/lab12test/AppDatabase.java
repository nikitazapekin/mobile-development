package com.example.lab12test;



import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


@Database(entities = {Customer.class, Purchase.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {
    public abstract CustomerDao customerDao();
    public abstract PurchaseDao purchaseDao();



    public abstract HumanDao humanDao();
    public abstract  HorseDao horseDao();
}