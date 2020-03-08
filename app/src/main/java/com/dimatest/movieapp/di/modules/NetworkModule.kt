package com.dimatest.movieapp.di.modules

import com.dimatest.movieapp.BuildConfig
import com.dimatest.movieapp.network.MovieService
import com.dimatest.movieapp.repositories.remote.MovieRemoteRepository
import com.dimatest.movieapp.repositories.remote.MovieRemoteRepositoryInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {

    factory<MovieService> { get<Retrofit>().create(MovieService::class.java) }

    factory<MovieRemoteRepositoryInterface> { MovieRemoteRepository(get()) }

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    single {
        OkHttpClient()
                .newBuilder()
                .addInterceptor(get<HttpLoggingInterceptor>())
                .build()
    }
    single {
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
                .client(get())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }
}