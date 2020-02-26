package com.dimatest.movieapp.usecases;

import com.dimatest.movieapp.common.BaseUseCaseSingle;
import com.dimatest.movieapp.database.entity.MovieDO;
import com.dimatest.movieapp.repositories.local.MovieLocalRepositoryInterface;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class GetMovieByIdUseCase extends BaseUseCaseSingle<MovieDO, GetMovieByIdUseCase.Data> {

    private MovieLocalRepositoryInterface movieLocalRepository;

    @Inject
    public GetMovieByIdUseCase(
            Scheduler mainThread, Scheduler ioThread,

            MovieLocalRepositoryInterface movieLocalRepository) {
        super(mainThread, ioThread);
        this.movieLocalRepository = movieLocalRepository;
    }

    @Override
    protected Single<MovieDO> buildUseCaseObservable(Data data) {
        return movieLocalRepository.getMovieById(data.id);
    }

    public static class Data {
        public long id;

        public Data(long id) {
            this.id = id;
        }
    }
}
