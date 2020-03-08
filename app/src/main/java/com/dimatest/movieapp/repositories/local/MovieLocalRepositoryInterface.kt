package com.dimatest.movieapp.repositories.local

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.PagedList.BoundaryCallback
import com.dimatest.movieapp.database.entity.MovieDO
import io.reactivex.Completable
import io.reactivex.Single

interface MovieLocalRepositoryInterface {
    fun insertAll(movieDOList: List<MovieDO>): Completable
    fun update(movieDO: MovieDO): Completable
    fun delete(movieDO: MovieDO): Completable
    fun deleteAll(): Completable
    fun getMovies(loadMovieCallback: BoundaryCallback<MovieDO>): LiveData<PagedList<MovieDO>>
    fun getMovieById(id: Long): Single<MovieDO>
}