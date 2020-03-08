package com.dimatest.movieapp.network.entity

import com.dimatest.movieapp.BuildConfig
import com.dimatest.movieapp.database.entity.MovieDO
import com.squareup.moshi.Json

data class Movie(
        @field:Json(name = "popularity")
        var popularity: Double? = null,

        @field:Json(name = "vote_count")
        var voteCount: Int? = null,

        @field:Json(name = "video")
        var video: Boolean? = null,

        @field:Json(name = "poster_path")
        var posterPath: String? = null,

        @field:Json(name = "id")
        var id: Long? = null,

        @field:Json(name = "adult")
        var adult: Boolean? = null,

        @field:Json(name = "backdrop_path")
        var backdropPath: String? = null,

        @field:Json(name = "original_language")
        var originalLanguage: String? = null,

        @field:Json(name = "original_title")
        var originalTitle: String? = null,

        @field:Json(name = "genre_ids")
        var genreIds: List<Int>? = null,

        @field:Json(name = "title")
        var title: String? = null,

        @field:Json(name = "vote_average")
        var voteAverage: Double? = null,

        @field:Json(name = "overview")
        var overview: String? = null,

        @field:Json(name = "release_date")
        var releaseDate: String? = null
) {

    fun mapToMovieDO(): MovieDO {
        return MovieDO(popularity, voteCount, video, BuildConfig.POSTER_URL + posterPath,
                id, adult, BuildConfig.POSTER_URL + backdropPath, originalLanguage,
                originalTitle, genreIds?.joinToString()
                ?: "", title, voteAverage, overview, releaseDate)
    }
}