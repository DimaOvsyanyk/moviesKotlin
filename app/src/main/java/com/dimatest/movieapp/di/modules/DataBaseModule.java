package com.dimatest.movieapp.di.modules;

import android.app.Application;

import com.dimatest.movieapp.database.AppDatabase;
import com.dimatest.movieapp.repositories.local.MovieLocalRepository;
import com.dimatest.movieapp.repositories.local.MovieLocalRepositoryInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataBaseModule {

    private Application app;

    public DataBaseModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application getApp() {
        return app;
    }

    @Provides
    @Singleton
    public AppDatabase appDatabase() {
        return AppDatabase.getInstance(app);
    }

    @Singleton
    @Provides
    public MovieLocalRepositoryInterface provideMovieLocalRepository(AppDatabase appDatabase) {
        return new MovieLocalRepository(appDatabase);
    }
}
