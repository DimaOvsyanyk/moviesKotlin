package com.dimatest.movieapp.common;

import androidx.core.util.Preconditions;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.observers.DisposableSingleObserver;

public abstract class BaseUseCaseSingle<T, Params> extends BaseUseCase {

    public BaseUseCaseSingle(Scheduler mainThread, Scheduler ioThread) {
        super(mainThread, ioThread);
    }

    abstract protected Single<T> buildUseCaseObservable(Params params);

    public void execute(Params params, DisposableSingleObserver<T> observer) {
        Preconditions.checkNotNull(observer);
        final Single<T> observable = this.buildUseCaseObservable(params)
                .subscribeOn(ioThread)
                .observeOn(mainThread)
                .doOnSubscribe(__ -> isLoading.postValue(true))
                .doOnTerminate(() -> isLoading.postValue(false))
                .doOnDispose(() -> isLoading.postValue(false));
        addDisposable(observable.subscribeWith(observer));
    }
}
