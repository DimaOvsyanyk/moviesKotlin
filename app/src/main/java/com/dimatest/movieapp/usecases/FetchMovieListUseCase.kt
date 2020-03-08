package com.dimatest.movieapp.usecases

import com.dimatest.movieapp.common.BaseUseCaseSingle
import com.dimatest.movieapp.repositories.local.MovieLocalRepositoryInterface
import com.dimatest.movieapp.repositories.remote.MovieRemoteRepositoryInterface
import com.dimatest.movieapp.ui.movieList.models.MoviePagedData
import com.dimatest.movieapp.utils.Const
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single

class FetchMovieListUseCase(
        mainThread: Scheduler, ioThread: Scheduler,
        private val movieRemoteRepository: MovieRemoteRepositoryInterface,
        private val movieLocalRepository: MovieLocalRepositoryInterface
) : BaseUseCaseSingle<MoviePagedData, FetchMovieListUseCase.Data>(mainThread, ioThread) {

    override fun buildUseCaseObservable(params: Data): Single<MoviePagedData> {
        return movieRemoteRepository.getMovies(params.page)
                .flatMap { movieResponse ->
                    if (movieResponse.page == Const.START_PAGE) {
                        return@flatMap movieLocalRepository.deleteAll()
                                .andThen(movieResponse.result?.let { movieList ->
                                            movieLocalRepository.insertAll(movieList.map { it.mapToMovieDO() })
                                        }
                                ).andThen(Single.just(movieResponse.mapToPagedData()))
                    } else {
                        return@flatMap (movieResponse.result?.let { movieList ->
                                    movieLocalRepository.insertAll(movieList.map { it.mapToMovieDO() })
                                } ?: Completable.complete())
                                .andThen(Single.just(movieResponse.mapToPagedData()))
                    }
                }
    }

    data class Data(val page: Int)
}