package com.dimatest.movieapp.usecases;

import com.dimatest.movieapp.common.BaseUseCaseSingle;
import com.dimatest.movieapp.database.entity.MovieDO;
import com.dimatest.movieapp.network.entity.Movie;
import com.dimatest.movieapp.repositories.local.MovieLocalRepositoryInterface;
import com.dimatest.movieapp.repositories.remote.MovieRemoteRepositoryInterface;
import com.dimatest.movieapp.ui.movieList.models.MoviePagedData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;

import static com.dimatest.movieapp.utils.Const.START_PAGE;

public class FetchMovieListUseCase extends BaseUseCaseSingle<MoviePagedData, FetchMovieListUseCase.Data> {

    private MovieRemoteRepositoryInterface movieRemoteRepository;
    private MovieLocalRepositoryInterface movieLocalRepository;

    @Inject
    public FetchMovieListUseCase(
            Scheduler mainThread, Scheduler ioThread,
            MovieRemoteRepositoryInterface movieRemoteRepository,
            MovieLocalRepositoryInterface movieLocalRepository) {
        super(mainThread, ioThread);
        this.movieRemoteRepository = movieRemoteRepository;
        this.movieLocalRepository = movieLocalRepository;
    }

    @Override
    protected Single<MoviePagedData> buildUseCaseObservable(Data data) {
        return movieRemoteRepository.getMovies(data.page)
                .flatMap(movieResponse -> {
                            if (movieResponse.getPage() == START_PAGE) {
                                return movieLocalRepository.deleteAll()
                                        .andThen(
                                                movieLocalRepository.insertAll(
                                                        convertToMovieDOList(movieResponse.getResult()))
                                        ).andThen(Single.just(movieResponse.mapToPagedData()));
                            } else {
                                return movieLocalRepository.insertAll(
                                        convertToMovieDOList(movieResponse.getResult()))
                                        .andThen(Single.just(movieResponse.mapToPagedData()));
                            }
                        }
                );
    }

    private List<MovieDO> convertToMovieDOList(List<Movie> movieList) {
        ArrayList<MovieDO> newList = new ArrayList<>();
        for (Movie movie : movieList) {
            newList.add(movie.mapToMovieDO());
        }
        return newList;
    }

    public static class Data {
        int page;

        public Data(int page) {
            this.page = page;
        }
    }
}
