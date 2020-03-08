package com.dimatest.movieapp.repositories.remote

import com.dimatest.movieapp.network.entity.MovieResponse
import io.reactivex.Single

interface MovieRemoteRepositoryInterface {
    fun getMovies(page: Int): Single<MovieResponse>
}