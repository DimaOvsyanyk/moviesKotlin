package com.dimatest.movieapp.common

import androidx.lifecycle.MutableLiveData
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseUseCase(protected val mainThread: Scheduler, protected val ioThread: Scheduler) {

    var isLoading = MutableLiveData<Boolean>()
    private val disposables = CompositeDisposable()

    fun clearDisposable() {
        disposables.clear()
    }

    protected fun addDisposable(disposable: Disposable?) {
        disposable?.let { disposables.add(it) }
    }
}