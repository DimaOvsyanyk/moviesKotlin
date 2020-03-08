package com.dimatest.movieapp.network

import com.dimatest.movieapp.network.entity.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/now_playing")
    fun getMovies(
            @Query("api_key") apiKey: String,
            @Query("page") page: Int
    ): Single<MovieResponse>
}