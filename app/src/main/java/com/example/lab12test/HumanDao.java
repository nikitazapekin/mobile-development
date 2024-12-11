package com.example.lab12test;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HumanDao {

    @Query("SELECT * FROM human")
    LiveData<List<Human>> getAll();

    @Query("SELECT * FROM human WHERE id = :id")
    LiveData<Human> getById(long id);

    @Insert
    void insert(Human human);

    @Update
    void update(Human human);

    @Delete
    void delete(Human human);


}
