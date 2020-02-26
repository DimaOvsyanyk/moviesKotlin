package com.dimatest.movieapp.di.modules;

import com.dimatest.movieapp.repositories.local.MovieLocalRepositoryInterface;
import com.dimatest.movieapp.repositories.remote.MovieRemoteRepositoryInterface;
import com.dimatest.movieapp.usecases.FetchMovieListUseCase;
import com.dimatest.movieapp.usecases.GetMovieByIdUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class UseCaseModule {

    private final Scheduler mainThread;
    private final Scheduler ioThread;

    public UseCaseModule() {
        mainThread = AndroidSchedulers.mainThread();
        ioThread = Schedulers.io();
    }

    @Provides
    @Singleton
    public FetchMovieListUseCase provideFetchMovieListUseCase(
            MovieLocalRepositoryInterface movieLocalRepository,
            MovieRemoteRepositoryInterface movieRemoteRepository
    ) {
        return new FetchMovieListUseCase(mainThread, ioThread, movieRemoteRepository, movieLocalRepository);
    }

    @Provides
    @Singleton
    public GetMovieByIdUseCase provideGetMovieByIdUseCase(
            MovieLocalRepositoryInterface movieLocalRepository
    ) {
        return new GetMovieByIdUseCase(mainThread, ioThread, movieLocalRepository);
    }
}
