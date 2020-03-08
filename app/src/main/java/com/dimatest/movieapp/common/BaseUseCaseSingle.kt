package com.dimatest.movieapp.common

import android.util.Log
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver

abstract class BaseUseCaseSingle<T, Params>(mainThread: Scheduler, ioThread: Scheduler) : BaseUseCase(mainThread, ioThread) {
    protected abstract fun buildUseCaseObservable(params: Params): Single<T>

    private fun execute(params: Params, observer: DisposableSingleObserver<T>) {
        val observable = buildUseCaseObservable(params)
                .subscribeOn(ioThread)
                .observeOn(mainThread)
                .doOnSubscribe { isLoading.postValue(true) }
                .doOnTerminate { isLoading.postValue(false) }
                .doOnDispose { isLoading.postValue(false) }
                .onErrorResumeNext { Single.error(it) }
        addDisposable(observable.subscribeWith(observer))
    }

    fun execute(
            params: Params,
            onSuccess: ((t: T) -> Unit)? = null,
            onError: ((Throwable) -> Unit)? = null
    ) {
        execute(params, object : DisposableSingleObserver<T>() {
            override fun onSuccess(t: T) {
                onSuccess?.invoke(t)
            }

            override fun onError(e: Throwable) {
                Log.d(this.javaClass.name, e.toString())
                onError?.invoke(e)
            }
        })
    }
}