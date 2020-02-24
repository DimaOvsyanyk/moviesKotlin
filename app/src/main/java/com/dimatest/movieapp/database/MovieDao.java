package com.dimatest.movieapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dimatest.movieapp.database.entity.MovieDO;

import io.reactivex.Completable;

@Dao
public interface MovieDao {

    @Insert
    Completable insertAll(MovieDO... movieDOList);

    @Update
    Completable update(MovieDO movieDO);

    @Delete
    Completable delete(MovieDO movieDO);

    @Query("DELETE FROM movies")
    Completable deleteAll();
}
