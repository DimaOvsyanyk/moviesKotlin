package com.dimatest.movieapp.common

import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableCompletableObserver

abstract class BaseUseCaseCompletable<Params>(
        mainThread: Scheduler, ioThread: Scheduler
) : BaseUseCase(mainThread, ioThread) {

    protected abstract fun buildUseCaseObservable(params: Params): Completable

    fun execute(params: Params, observer: DisposableCompletableObserver) {
        val observable = buildUseCaseObservable(params)
                .subscribeOn(ioThread)
                .observeOn(mainThread)
                .doOnSubscribe { isLoading.postValue(true) }
                .doOnTerminate { isLoading.postValue(false) }
                .doOnDispose { isLoading.postValue(false) }
        addDisposable(observable.subscribeWith(observer))
    }
}