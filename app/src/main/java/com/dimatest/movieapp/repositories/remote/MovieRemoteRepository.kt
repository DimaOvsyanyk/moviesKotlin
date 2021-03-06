package com.dimatest.movieapp.repositories.remote

import com.dimatest.movieapp.BuildConfig
import com.dimatest.movieapp.network.MovieService
import com.dimatest.movieapp.network.entity.MovieResponse
import io.reactivex.Single

class MovieRemoteRepository (private val movieService: MovieService) : MovieRemoteRepositoryInterface {

    override fun getMovies(page: Int): Single<MovieResponse> {
        return movieService.getMovies(BuildConfig.API_KEY, page)
    }
}