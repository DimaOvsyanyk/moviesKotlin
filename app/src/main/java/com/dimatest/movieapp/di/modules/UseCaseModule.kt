package com.dimatest.movieapp.di.modules

import com.dimatest.movieapp.usecases.FetchMovieListUseCase
import com.dimatest.movieapp.usecases.GetMovieByIdUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { FetchMovieListUseCase(get(), get()) }
    factory { GetMovieByIdUseCase(get()) }
}