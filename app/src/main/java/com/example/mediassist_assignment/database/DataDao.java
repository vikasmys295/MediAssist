package com.example.mediassist_assignment.database;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface DataDao {

    @Insert
    void insert(Data data);
}
