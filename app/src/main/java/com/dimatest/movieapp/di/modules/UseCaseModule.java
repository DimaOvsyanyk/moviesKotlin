package com.dimatest.movieapp.di.modules;

import dagger.Module;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class UseCaseModule {

    private final Scheduler mainThread;
    private final Scheduler ioThread;

    public UseCaseModule() {
        mainThread = AndroidSchedulers.mainThread();
        ioThread = Schedulers.io();
    }
}
