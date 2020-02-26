package com.dimatest.movieapp.repositories.remote;

import com.dimatest.movieapp.network.entity.MovieResponse;

import io.reactivex.Single;

public interface MovieRemoteRepositoryInterface {

    Single<MovieResponse> getMovies(int page);
}
