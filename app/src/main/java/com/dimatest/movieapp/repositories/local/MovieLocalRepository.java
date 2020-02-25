package com.dimatest.movieapp.repositories.local;

import com.dimatest.movieapp.database.AppDatabase;
import com.dimatest.movieapp.database.MovieDao;

public class MovieLocalRepository implements MovieLocalRepositoryInterface {

    private MovieDao movieDao;

    public MovieLocalRepository(AppDatabase appDatabase) {
        this.movieDao = appDatabase.movieDao();
    }
}
