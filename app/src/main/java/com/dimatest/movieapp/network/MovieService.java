package com.dimatest.movieapp.network;

import com.dimatest.movieapp.network.entity.MovieResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET("movie/now_playing")
    Single<MovieResponse> getMovies(
            @Query("api_key") String apiKey,
            @Query("page") int page
    );
}
