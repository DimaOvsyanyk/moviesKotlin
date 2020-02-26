package com.dimatest.movieapp.common;

import androidx.core.util.Preconditions;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableCompletableObserver;

public abstract class BaseUseCaseCompletable<Params> extends BaseUseCase{

    public BaseUseCaseCompletable(Scheduler mainThread, Scheduler ioThread) {
        super(mainThread, ioThread);
    }

    abstract protected Completable buildUseCaseObservable(Params params);

    public void execute(Params params, DisposableCompletableObserver observer) {
        Preconditions.checkNotNull(observer);
        final Completable observable = this.buildUseCaseObservable(params)
                .subscribeOn(ioThread)
                .observeOn(mainThread)
                .doOnSubscribe(__ -> isLoading.postValue(true))
                .doOnTerminate(() -> isLoading.postValue(false))
                .doOnDispose(() -> isLoading.postValue(false));
        addDisposable(observable.subscribeWith(observer));
    }
}
