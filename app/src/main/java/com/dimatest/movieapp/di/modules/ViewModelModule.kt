package com.dimatest.movieapp.di.modules

import com.dimatest.movieapp.ui.movieDetails.MovieDetailsViewModel
import com.dimatest.movieapp.ui.movieList.MovieListViewModel
import com.dimatest.movieapp.ui.splash.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashScreenViewModel() }
    viewModel { MovieListViewModel(get(), get()) }
    viewModel { MovieDetailsViewModel(get()) }
}