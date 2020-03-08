package com.dimatest.movieapp.network.entity

import com.dimatest.movieapp.ui.movieList.models.MoviePagedData
import com.dimatest.movieapp.utils.safeLet
import com.squareup.moshi.Json

data class MovieResponse(
        @field:Json(name = "results")
    var result: List<Movie>? = null,

        @field:Json(name = "page")
    var page: Int? = null,

        @field:Json(name = "total_results")
    var totalResults: Long? = null,

        @field:Json(name = "total_pages")
    var totalPages: Int? = null
) {

    fun mapToPagedData() = safeLet(page, totalResults, totalPages) { page, totalResults, totalPages ->
        MoviePagedData(page, totalResults, totalPages)
    } ?: MoviePagedData(0,0,0)
}