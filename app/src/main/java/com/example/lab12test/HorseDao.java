package com.example.lab12test;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HorseDao {

    @Query("SELECT * FROM horse")
    LiveData<List<Horse>> getAll();

    @Query("SELECT * FROM horse WHERE id = :id")
    LiveData<Horse> getById(long id);

    @Query("SELECT * FROM horse WHERE owner_id = :ownerId")
    LiveData<List<Horse>> getAllByOwnerId(long ownerId);

    @Insert
    void insert(Horse horse);

    @Update
    void update(Horse horse);

    @Delete
    void delete(Horse horse);

}
