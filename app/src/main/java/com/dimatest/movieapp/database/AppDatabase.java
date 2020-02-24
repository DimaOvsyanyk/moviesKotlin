package com.dimatest.movieapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dimatest.movieapp.database.entity.MovieDO;

@Database(entities = {MovieDO.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;
    public abstract MovieDao movieDao();

    public synchronized static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "MoviesDatabase")
                    .fallbackToDestructiveMigration() // only while development
                    .build();
        }
        return instance;
    }
}
