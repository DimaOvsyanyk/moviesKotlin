package com.dimatest.movieapp.repositories.local

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.PagedList.BoundaryCallback
import com.dimatest.movieapp.database.entity.MovieDO

interface MovieLocalRepositoryInterface {
    suspend fun insertAll(movieDOList: List<MovieDO>)
    suspend fun update(movieDO: MovieDO)
    suspend fun delete(movieDO: MovieDO)
    suspend fun deleteAll()
    fun getMovies(loadMovieCallback: BoundaryCallback<MovieDO>): LiveData<PagedList<MovieDO>>
    suspend fun getMovieById(id: Long): MovieDO
}