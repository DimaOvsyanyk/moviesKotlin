package com.dimatest.movieapp.di.modules

import com.dimatest.movieapp.usecases.FetchMovieListUseCase
import com.dimatest.movieapp.usecases.GetMovieByIdUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module

val useCaseModule = module {
    factory { FetchMovieListUseCase(AndroidSchedulers.mainThread(), Schedulers.io(), get(), get()) }
    factory { GetMovieByIdUseCase(AndroidSchedulers.mainThread(), Schedulers.io(), get()) }
}