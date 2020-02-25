package com.dimatest.movieapp.di.component;

import com.dimatest.movieapp.di.modules.ViewModelModule;
import com.dimatest.movieapp.ui.movieDetails.MovieDetailsFragment;
import com.dimatest.movieapp.ui.movieList.MovieListFragment;
import com.dimatest.movieapp.ui.splash.SplashScreenFragment;
import com.dimatest.movieapp.app.MovieApp;
import com.dimatest.movieapp.di.modules.DataBaseModule;
import com.dimatest.movieapp.di.modules.NetworkModule;
import com.dimatest.movieapp.di.modules.UseCaseModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, DataBaseModule.class,
        NetworkModule.class, UseCaseModule.class, ViewModelModule.class})
public interface AppComponent {

    void inject(MovieApp movieApp);
    void inject(SplashScreenFragment fragment);
    void inject(MovieListFragment fragment);
    void inject(MovieDetailsFragment fragment);
}
