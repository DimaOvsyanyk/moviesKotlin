package com.dimatest.movieapp.ui.movieList;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.dimatest.movieapp.common.BaseViewModel;
import com.dimatest.movieapp.database.entity.MovieDO;
import com.dimatest.movieapp.repositories.local.MovieLocalRepositoryInterface;
import com.dimatest.movieapp.ui.movieList.models.MoviePagedData;
import com.dimatest.movieapp.usecases.FetchMovieListUseCase;

import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;

import static com.dimatest.movieapp.utils.Const.START_PAGE;

public class MovieListViewModel extends BaseViewModel {

    private LiveData<PagedList<MovieDO>> movieList;
    private FetchMovieListUseCase fetchMovieListUseCase;
    private final PagedList.BoundaryCallback<MovieDO> loadMovieCallback = new PagedList.BoundaryCallback<MovieDO>() {
        @Override
        public void onZeroItemsLoaded() {
            super.onZeroItemsLoaded();
        }

        @Override
        public void onItemAtFrontLoaded(@NonNull MovieDO itemAtFront) {
            super.onItemAtFrontLoaded(itemAtFront);
        }

        @Override
        public void onItemAtEndLoaded(@NonNull MovieDO itemAtEnd) {
            super.onItemAtEndLoaded(itemAtEnd);
            loadMovies();
        }
    };

    private boolean hasMoreMovies = true;
    private boolean isMoviesLoading = false;
    private int page = START_PAGE;

    @Inject
    public MovieListViewModel(MovieLocalRepositoryInterface movieLocalRepository,
                              FetchMovieListUseCase fetchMovieListUseCase) {
        this.fetchMovieListUseCase = fetchMovieListUseCase;
        movieList = movieLocalRepository.getMovies(loadMovieCallback);
        loadFirstPage();
    }

    public void loadFirstPage() {
        page = START_PAGE;
        hasMoreMovies = true;
        loadMovies();
    }

    private void loadMovies() {
        if (!isMoviesLoading && hasMoreMovies) {
            fetchMovieListUseCase.execute(
                    new FetchMovieListUseCase.Data(page),
                    new DisposableSingleObserver<MoviePagedData>() {

                        @Override
                        public void onSuccess(MoviePagedData moviePagedData) {
                            page = moviePagedData.getNextPage();
                            hasMoreMovies = moviePagedData.hasMoreMovies();
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d("loadMovies", Objects.requireNonNull(e.getMessage()));
                        }
                    });
        }
    }

    public LiveData<Boolean> getMoviesLoading() {
        return fetchMovieListUseCase.isLoading;
    }

    public LiveData<PagedList<MovieDO>> getMovieList() {
        return movieList;
    }

    public void setMoviesLoading(boolean moviesLoading) {
        isMoviesLoading = moviesLoading;
    }

    @Override
    protected void onCleared() {
        fetchMovieListUseCase.clearDisposable();
        super.onCleared();
    }
}
