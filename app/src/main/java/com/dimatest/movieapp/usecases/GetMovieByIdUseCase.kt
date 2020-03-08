package com.dimatest.movieapp.usecases

import com.dimatest.movieapp.common.BaseUseCaseWithResult
import com.dimatest.movieapp.database.entity.MovieDO
import com.dimatest.movieapp.repositories.local.MovieLocalRepositoryInterface

class GetMovieByIdUseCase(
        private val movieLocalRepository: MovieLocalRepositoryInterface
) : BaseUseCaseWithResult<MovieDO, GetMovieByIdUseCase.Data>() {

    override suspend fun run(params: Data): MovieDO {
        return movieLocalRepository.getMovieById(params.id)
    }

    data class Data(val id: Long)
}