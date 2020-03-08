package com.dimatest.movieapp.ui.movieList

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import androidx.paging.PagedList.BoundaryCallback
import com.dimatest.movieapp.common.BaseViewModel
import com.dimatest.movieapp.database.entity.MovieDO
import com.dimatest.movieapp.repositories.local.MovieLocalRepositoryInterface
import com.dimatest.movieapp.usecases.FetchMovieListUseCase
import com.dimatest.movieapp.utils.Const

class MovieListViewModel(
        movieLocalRepository: MovieLocalRepositoryInterface,
        private val fetchMovieListUseCase: FetchMovieListUseCase
) : BaseViewModel() {

    val movieList: LiveData<PagedList<MovieDO>>
    val isLoading = ObservableBoolean(false)

    private val loadMovieCallback: BoundaryCallback<MovieDO> = object : BoundaryCallback<MovieDO>() {

        override fun onItemAtEndLoaded(itemAtEnd: MovieDO) {
            super.onItemAtEndLoaded(itemAtEnd)
            loadMovies()
        }
    }
    private var hasMoreMovies = true
    private var page = Const.START_PAGE

    init {
        movieList = movieLocalRepository.getMovies(loadMovieCallback)
        loadFirstPage()
    }

    fun loadFirstPage() {
        page = Const.START_PAGE
        hasMoreMovies = true
        loadMovies()
    }

    private fun loadMovies() {
        if (!isLoading.get() && hasMoreMovies) {
            fetchMovieListUseCase.invoke(viewModelScope, FetchMovieListUseCase.Data(page)) {
                page = it.nextPage
                hasMoreMovies = it.hasMoreMovies()
            }
        }
    }

    fun moviesLoading() = fetchMovieListUseCase.isLoading
}