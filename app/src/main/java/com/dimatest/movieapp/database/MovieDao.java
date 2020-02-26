package com.dimatest.movieapp.database;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dimatest.movieapp.database.entity.MovieDO;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertAll(List<MovieDO> movieDOList);

    @Update
    Completable update(MovieDO movieDO);

    @Delete
    Completable delete(MovieDO movieDO);

    @Query("DELETE FROM movies")
    Completable deleteAll();

    @Query("SELECT * FROM movies")
    DataSource.Factory<Integer, MovieDO> getMoviesPaged();

    @Query("SELECT * FROM movies WHERE id =:id")
    Single<MovieDO> getMovieById(long id);
}
