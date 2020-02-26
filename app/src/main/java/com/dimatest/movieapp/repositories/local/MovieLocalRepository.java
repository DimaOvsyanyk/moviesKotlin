package com.dimatest.movieapp.repositories.local;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.dimatest.movieapp.database.AppDatabase;
import com.dimatest.movieapp.database.MovieDao;
import com.dimatest.movieapp.database.entity.MovieDO;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

import static com.dimatest.movieapp.utils.Const.PAGE_SIZE;

public class MovieLocalRepository implements MovieLocalRepositoryInterface {

    private MovieDao movieDao;

    @Inject
    public MovieLocalRepository(AppDatabase appDatabase) {
        this.movieDao = appDatabase.movieDao();
    }

    @Override
    public Completable insertAll(List<MovieDO> movieDOList) {
        return movieDao.insertAll(movieDOList);
    }

    @Override
    public Completable update(MovieDO movieDO) {
        return movieDao.update(movieDO);
    }

    @Override
    public Completable delete(MovieDO movieDO) {
        return movieDao.delete(movieDO);
    }

    @Override
    public Completable deleteAll() {
        return movieDao.deleteAll();
    }

    @Override
    public LiveData<PagedList<MovieDO>> getMovies(PagedList.BoundaryCallback<MovieDO> loadMovieCallback) {
        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .build();
        return new LivePagedListBuilder<>(movieDao.getMoviesPaged(), config)
                .setBoundaryCallback(loadMovieCallback)
                .build();
    }

    @Override
    public Single<MovieDO> getMovieById(long id) {
        return movieDao.getMovieById(id);
    }
}
