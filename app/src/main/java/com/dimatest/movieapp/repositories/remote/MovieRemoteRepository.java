package com.dimatest.movieapp.repositories.remote;

import com.dimatest.movieapp.BuildConfig;
import com.dimatest.movieapp.network.MovieService;
import com.dimatest.movieapp.network.entity.MovieResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class MovieRemoteRepository implements MovieRemoteRepositoryInterface {

    private MovieService movieService;

    @Inject
    public MovieRemoteRepository(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public Single<MovieResponse> getMovies(int page) {
        return movieService.getMovies(BuildConfig.API_KEY, page);
    }
}
