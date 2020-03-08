package com.dimatest.movieapp.database

import androidx.paging.DataSource
import androidx.room.*
import com.dimatest.movieapp.database.entity.MovieDO

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movieDOList: List<MovieDO>)

    @Update
    suspend fun update(movieDO: MovieDO)

    @Delete
    suspend fun delete(movieDO: MovieDO)

    @Query("DELETE FROM movies")
    suspend fun deleteAll()

    @Query("SELECT * FROM movies")
    fun getMoviesPaged(): DataSource.Factory<Int, MovieDO>

    @Query("SELECT * FROM movies WHERE id =:id")
    suspend fun getMovieById(id: Long): MovieDO
}