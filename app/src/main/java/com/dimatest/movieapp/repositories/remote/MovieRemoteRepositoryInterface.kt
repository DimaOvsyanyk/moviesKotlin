package com.dimatest.movieapp.repositories.remote

import com.dimatest.movieapp.network.entity.MovieResponse

interface MovieRemoteRepositoryInterface {

    suspend fun getMovies(page: Int): MovieResponse
}