package com.dimatest.movieapp.ui.movieDetails

import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.dimatest.movieapp.common.BaseViewModel
import com.dimatest.movieapp.database.entity.MovieDO
import com.dimatest.movieapp.usecases.GetMovieByIdUseCase

class MovieDetailsViewModel(
        private val getMovieByIdUseCase: GetMovieByIdUseCase
) : BaseViewModel() {

    val movieDetails = ObservableField<MovieDO>()

    fun getMovie(id: Long) {
        getMovieByIdUseCase.invoke(viewModelScope, GetMovieByIdUseCase.Data(id)) {
            movieDetails.set(it)
        }
    }
}