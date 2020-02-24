package com.dimatest.movieapp.App;

import android.app.Application;

import com.dimatest.movieapp.di.component.AppComponent;
import com.dimatest.movieapp.di.component.DaggerAppComponent;

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

                .build();
        appComponent.inject(this);
    }
}
