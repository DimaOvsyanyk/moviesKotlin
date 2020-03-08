package com.dimatest.movieapp.repositories.remote

import com.dimatest.movieapp.BuildConfig
import com.dimatest.movieapp.network.MovieService
import com.dimatest.movieapp.network.entity.MovieResponse

class MovieRemoteRepository (private val movieService: MovieService) : MovieRemoteRepositoryInterface {

    override suspend fun getMovies(page: Int): MovieResponse {
        return movieService.getMovies(BuildConfig.API_KEY, page)
    }
}