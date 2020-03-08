package com.dimatest.movieapp.usecases

import com.dimatest.movieapp.common.BaseUseCaseWithResult
import com.dimatest.movieapp.repositories.local.MovieLocalRepositoryInterface
import com.dimatest.movieapp.repositories.remote.MovieRemoteRepositoryInterface
import com.dimatest.movieapp.ui.movieList.models.MoviePagedData
import com.dimatest.movieapp.utils.Const

class FetchMovieListUseCase(
        private val movieRemoteRepository: MovieRemoteRepositoryInterface,
        private val movieLocalRepository: MovieLocalRepositoryInterface
) : BaseUseCaseWithResult<MoviePagedData, FetchMovieListUseCase.Data>() {

    override suspend fun run(params: Data): MoviePagedData {
        val movieResponse = movieRemoteRepository.getMovies(params.page)
        if (movieResponse.page == Const.START_PAGE) movieLocalRepository.deleteAll()
        movieResponse.result?.let { movieList ->
            movieLocalRepository.insertAll(movieList.map { it.mapToMovieDO() })
        }
        return movieResponse.mapToPagedData()
    }

    data class Data(val page: Int)
}