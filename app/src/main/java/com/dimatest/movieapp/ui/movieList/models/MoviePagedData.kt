package com.dimatest.movieapp.ui.movieList.models

class MoviePagedData(var page: Int, var total_results: Long, var total_pages: Int) {

    val nextPage: Int
        get() = page + 1

    fun hasMoreMovies(): Boolean {
        return page < total_pages
    }

}