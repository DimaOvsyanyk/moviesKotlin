package com.dimatest.movieapp.repositories.local

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.PagedList.BoundaryCallback
import com.dimatest.movieapp.database.AppDatabase
import com.dimatest.movieapp.database.MovieDao
import com.dimatest.movieapp.database.entity.MovieDO
import com.dimatest.movieapp.utils.Const

class MovieLocalRepository(appDatabase: AppDatabase) : MovieLocalRepositoryInterface {

    private val movieDao: MovieDao = appDatabase.movieDao()

    override suspend fun insertAll(movieDOList: List<MovieDO>) = movieDao.insertAll(movieDOList)
    override suspend fun update(movieDO: MovieDO) = movieDao.update(movieDO)
    override suspend fun delete(movieDO: MovieDO) = movieDao.delete(movieDO)
    override suspend fun deleteAll() = movieDao.deleteAll()

    override fun getMovies(loadMovieCallback: BoundaryCallback<MovieDO>): LiveData<PagedList<MovieDO>> {
        val config = PagedList.Config.Builder()
                .setPageSize(Const.PAGE_SIZE)
                .build()
        return LivePagedListBuilder(movieDao.getMoviesPaged(), config)
                .setBoundaryCallback(loadMovieCallback)
                .build()
    }

    override suspend fun getMovieById(id: Long): MovieDO {
        return movieDao.getMovieById(id)
    }
}