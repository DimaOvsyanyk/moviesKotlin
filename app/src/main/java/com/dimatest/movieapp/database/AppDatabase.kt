package com.dimatest.movieapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dimatest.movieapp.database.entity.MovieDO

@Database(entities = [MovieDO::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}