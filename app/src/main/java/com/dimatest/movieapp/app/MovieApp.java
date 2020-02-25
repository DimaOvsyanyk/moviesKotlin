package com.dimatest.movieapp.app;

import android.app.Application;

import com.dimatest.movieapp.di.component.AppComponent;
import com.dimatest.movieapp.di.component.DaggerAppComponent;
import com.dimatest.movieapp.di.modules.DataBaseModule;
import com.dimatest.movieapp.di.modules.NetworkModule;
import com.dimatest.movieapp.di.modules.UseCaseModule;

public class MovieApp extends Application {

    private static MovieApp app;
    private AppComponent appComponent;

    public static MovieApp getApp() {
        return app;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        appComponent = DaggerAppComponent.builder()
                .dataBaseModule(new DataBaseModule(getApp()))
                .networkModule(new NetworkModule())
                .useCaseModule(new UseCaseModule())
                .build();
        appComponent.inject(this);
    }
}
