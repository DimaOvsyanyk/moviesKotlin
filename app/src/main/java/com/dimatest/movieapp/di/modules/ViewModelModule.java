package com.dimatest.movieapp.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.dimatest.movieapp.di.ViewModelFactory;
import com.dimatest.movieapp.ui.movieDetails.MovieDetailsViewModel;
import com.dimatest.movieapp.ui.movieList.MovieListViewModel;
import com.dimatest.movieapp.ui.splash.SplashScreenViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(SplashScreenViewModel.class)
    abstract ViewModel splashScreenViewModel(SplashScreenViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel.class)
    abstract ViewModel movieListViewModel(MovieListViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailsViewModel.class)
    abstract ViewModel movieDetailsViewModel(MovieDetailsViewModel viewModel);

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }
}
