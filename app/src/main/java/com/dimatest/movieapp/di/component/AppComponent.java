package com.dimatest.movieapp.di.component;

import com.dimatest.movieapp.app.MovieApp;
import com.dimatest.movieapp.di.modules.DataBaseModule;
import com.dimatest.movieapp.di.modules.NetworkModule;
import com.dimatest.movieapp.di.modules.UseCaseModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, DataBaseModule.class,
        NetworkModule.class, UseCaseModule.class})
public interface AppComponent {

    void inject(MovieApp movieApp);
}
