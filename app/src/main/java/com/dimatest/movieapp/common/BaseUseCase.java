package com.dimatest.movieapp.common;

import androidx.core.util.Preconditions;
import androidx.lifecycle.MutableLiveData;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseUseCase {

    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    protected final Scheduler mainThread;
    protected final Scheduler ioThread;
    protected final CompositeDisposable disposables;

    public BaseUseCase(Scheduler mainThread, Scheduler ioThread) {
        this.mainThread = mainThread;
        this.ioThread = ioThread;
        this.disposables = new CompositeDisposable();
    }

    public void clearDisposable() {
        disposables.clear();
    }

    protected void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(disposables);
        disposables.add(disposable);
    }
}
