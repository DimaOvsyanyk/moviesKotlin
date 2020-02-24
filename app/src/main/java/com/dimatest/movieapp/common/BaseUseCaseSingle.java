package com.dimatest.movieapp.common;

import androidx.core.util.Preconditions;
import androidx.lifecycle.MutableLiveData;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;

public abstract class BaseUseCaseSingle<T, Params> {

    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    private final Scheduler mainThread;
    private final Scheduler ioThread;
    private final CompositeDisposable disposables;

    BaseUseCaseSingle(Scheduler mainThread, Scheduler ioThread) {
        this.mainThread = mainThread;
        this.ioThread = ioThread;
        this.disposables = new CompositeDisposable();
    }

    abstract Single<T> buildUseCaseObservable(Params params);

    public void execute(DisposableSingleObserver<T> observer, Params params) {
        Preconditions.checkNotNull(observer);
        final Single<T> observable = this.buildUseCaseObservable(params)
                .subscribeOn(ioThread)
                .observeOn(mainThread)
                .doOnSubscribe(__ -> isLoading.postValue(true))
                .doOnTerminate(() -> isLoading.postValue(true))
                .doOnDispose(() -> isLoading.postValue(false));
        addDisposable(observable.subscribeWith(observer));
    }

    public void clearDisposable() {
        disposables.clear();
    }

    private void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(disposables);
        disposables.add(disposable);
    }
}
