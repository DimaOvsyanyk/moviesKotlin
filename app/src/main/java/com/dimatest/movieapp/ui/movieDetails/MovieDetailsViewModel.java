package com.dimatest.movieapp.ui.movieDetails;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.dimatest.movieapp.common.BaseViewModel;
import com.dimatest.movieapp.database.entity.MovieDO;
import com.dimatest.movieapp.usecases.GetMovieByIdUseCase;

import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;

public class MovieDetailsViewModel extends BaseViewModel {

    private ObservableField<MovieDO> movieDetails = new ObservableField<>();
    private GetMovieByIdUseCase getMovieByIdUseCase;

    @Inject
    public MovieDetailsViewModel(GetMovieByIdUseCase getMovieByIdUseCase) {
        this.getMovieByIdUseCase = getMovieByIdUseCase;
    }

    public void getMovie(long id) {
        getMovieByIdUseCase.execute(
                new GetMovieByIdUseCase.Data(id),
                new DisposableSingleObserver<MovieDO>() {

                    @Override
                    public void onSuccess(MovieDO movie) {
                        movieDetails.set(movie);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("loadMovies", Objects.requireNonNull(e.getMessage()));
                    }
                });
    }

    public ObservableField<MovieDO> getMovieDetails() {
        return movieDetails;
    }

    @Override
    protected void onCleared() {
        getMovieByIdUseCase.clearDisposable();
        super.onCleared();
    }
}
