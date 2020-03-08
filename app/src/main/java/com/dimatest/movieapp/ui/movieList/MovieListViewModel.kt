package com.dimatest.movieapp.ui.movieList

import androidx.lifecycle.LiveData
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

    private val loadMovieCallback: BoundaryCallback<MovieDO> = object : BoundaryCallback<MovieDO>() {

        override fun onItemAtEndLoaded(itemAtEnd: MovieDO) {
            super.onItemAtEndLoaded(itemAtEnd)
            loadMovies()
        }
    }
    private var hasMoreMovies = true
    private var isMoviesLoading = false
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
        if (!isMoviesLoading && hasMoreMovies) {
            fetchMovieListUseCase.execute(
                    FetchMovieListUseCase.Data(page),
                    onSuccess = {
                        page = it.nextPage
                        hasMoreMovies = it.hasMoreMovies()
                    })
        }
    }

    fun getMoviesLoading() =  fetchMovieListUseCase.isLoading

    fun setMoviesLoading(moviesLoading: Boolean) {
        isMoviesLoading = moviesLoading
    }

    override fun onCleared() {
        fetchMovieListUseCase.clearDisposable()
        super.onCleared()
    }
}