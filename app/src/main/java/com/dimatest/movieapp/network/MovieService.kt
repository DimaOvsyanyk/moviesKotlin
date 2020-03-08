package com.dimatest.movieapp.network

import com.dimatest.movieapp.network.entity.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/now_playing")
    suspend fun getMovies(
            @Query("api_key") apiKey: String, @Query("page") page: Int
    ): MovieResponse
}