package com.dimatest.movieapp.repositories.remote;

import com.dimatest.movieapp.network.MovieService;

public class MovieRemoteRepository implements MovieRemoteRepositoryInterface {

    private MovieService movieService;

    public MovieRemoteRepository(MovieService movieService) {
        this.movieService = movieService;
    }
}
