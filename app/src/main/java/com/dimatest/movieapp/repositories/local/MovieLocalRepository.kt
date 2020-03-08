package com.dimatest.movieapp.repositories.local

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.PagedList.BoundaryCallback
import com.dimatest.movieapp.database.AppDatabase
import com.dimatest.movieapp.database.MovieDao
import com.dimatest.movieapp.database.entity.MovieDO
import com.dimatest.movieapp.utils.Const
import io.reactivex.Completable
import io.reactivex.Single

class MovieLocalRepository(appDatabase: AppDatabase) : MovieLocalRepositoryInterface {

    private val movieDao: MovieDao = appDatabase.movieDao()

    override fun insertAll(movieDOList: List<MovieDO>): Completable {
        return movieDao.insertAll(movieDOList)
    }

    override fun update(movieDO: MovieDO): Completable {
        return movieDao.update(movieDO)
    }

    override fun delete(movieDO: MovieDO): Completable {
        return movieDao.delete(movieDO)
    }

    override fun deleteAll(): Completable {
        return movieDao.deleteAll()
    }

    override fun getMovies(loadMovieCallback: BoundaryCallback<MovieDO>): LiveData<PagedList<MovieDO>> {
        val config = PagedList.Config.Builder()
                .setPageSize(Const.PAGE_SIZE)
                .build()
        return LivePagedListBuilder(movieDao.getMoviesPaged(), config)
                .setBoundaryCallback(loadMovieCallback)
                .build()
    }

    override fun getMovieById(id: Long): Single<MovieDO> {
        return movieDao.getMovieById(id)
    }
}