
package com.example.lab12test;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;



import java.util.List;

@Dao
public interface CustomerDao {

    @Query("SELECT * FROM customer")
    LiveData<List<Customer>> getAll();

    @Query("SELECT * FROM customer WHERE id = :id")
    LiveData<Customer> getById(long id);

    @Insert
    void insert(Customer customer);

    @Update
    void update(Customer customer);

    @Delete
    void delete(Customer customer);
}
