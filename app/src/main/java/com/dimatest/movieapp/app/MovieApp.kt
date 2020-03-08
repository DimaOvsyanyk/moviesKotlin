package com.dimatest.movieapp.app

import android.app.Application
import com.dimatest.movieapp.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MovieApp)
            modules(listOf(dataBaseModule, networkModule,
                    useCaseModule, viewModelModule))
        }
    }
}