package com.dimatest.movieapp.database

import androidx.paging.DataSource
import androidx.room.*
import com.dimatest.movieapp.database.entity.MovieDO
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movieDOList: List<MovieDO>): Completable

    @Update
    fun update(movieDO: MovieDO): Completable

    @Delete
    fun delete(movieDO: MovieDO): Completable

    @Query("DELETE FROM movies")
    fun deleteAll(): Completable

    @Query("SELECT * FROM movies")
    fun getMoviesPaged(): DataSource.Factory<Int, MovieDO>

    @Query("SELECT * FROM movies WHERE id =:id")
    fun getMovieById(id: Long): Single<MovieDO>
}