package com.dimatest.movieapp.repositories.local;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.dimatest.movieapp.database.entity.MovieDO;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface MovieLocalRepositoryInterface {

    Completable insertAll(List<MovieDO> movieDOList);
    Completable update(MovieDO movieDO);
    Completable delete(MovieDO movieDO);
    Completable deleteAll();
    LiveData<PagedList<MovieDO>> getMovies(PagedList.BoundaryCallback<MovieDO> loadMovieCallback);
    Single<MovieDO> getMovieById(long id);
}
