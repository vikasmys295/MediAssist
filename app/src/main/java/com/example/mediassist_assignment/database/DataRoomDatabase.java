package com.example.mediassist_assignment.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Data.class,version = 2)
public abstract class DataRoomDatabase extends RoomDatabase {

    public abstract DataDao dataDao();

    private static volatile DataRoomDatabase dataRoomInstance;

    public static DataRoomDatabase getDataRoomDatabase(final Context context){
        if(dataRoomInstance == null){
            synchronized (DataRoomDatabase.class){
                if(dataRoomInstance == null){
                    dataRoomInstance = Room.databaseBuilder(context.getApplicationContext(),
                            DataRoomDatabase.class,"data_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return dataRoomInstance;
    }
}
