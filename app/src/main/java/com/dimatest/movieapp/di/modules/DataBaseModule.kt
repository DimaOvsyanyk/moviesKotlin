package com.dimatest.movieapp.di.modules

import androidx.room.Room
import com.dimatest.movieapp.database.AppDatabase
import com.dimatest.movieapp.repositories.local.MovieLocalRepository
import com.dimatest.movieapp.repositories.local.MovieLocalRepositoryInterface
import org.koin.dsl.module

val dataBaseModule = module {
    single {
        Room.databaseBuilder(
                        get(),
                        AppDatabase::class.java, "MoviesDatabase"
                )
                .fallbackToDestructiveMigration()
                .build()
    }
    factory<MovieLocalRepositoryInterface> {
        MovieLocalRepository(get())
    }
}