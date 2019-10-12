package com.example.roomdb.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PurchaseDao {

    @Insert
    int insert(Purchase purchase);

    @Query("select * from petrol")
    List<Purchase> getAll();
}
