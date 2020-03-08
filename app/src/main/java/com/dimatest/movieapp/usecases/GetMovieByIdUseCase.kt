package com.dimatest.movieapp.usecases

import com.dimatest.movieapp.common.BaseUseCaseSingle
import com.dimatest.movieapp.database.entity.MovieDO
import com.dimatest.movieapp.repositories.local.MovieLocalRepositoryInterface
import io.reactivex.Scheduler
import io.reactivex.Single

class GetMovieByIdUseCase(
        mainThread: Scheduler, ioThread: Scheduler,
        private val movieLocalRepository: MovieLocalRepositoryInterface
) : BaseUseCaseSingle<MovieDO, GetMovieByIdUseCase.Data>(mainThread, ioThread) {

    override fun buildUseCaseObservable(params: Data): Single<MovieDO> {
        return movieLocalRepository.getMovieById(params.id)
    }

    data class Data(val id: Long)
}