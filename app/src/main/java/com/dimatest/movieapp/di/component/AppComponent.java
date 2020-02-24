package com.dimatest.movieapp.di.component;

import com.dimatest.movieapp.App.MovieApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class})
public interface AppComponent {

    void inject(MovieApp movieApp);
}
