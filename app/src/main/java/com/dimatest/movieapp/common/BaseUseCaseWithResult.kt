package com.dimatest.movieapp.common

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BaseUseCaseWithResult<out Type, in Params> where Type : Any {

    var isLoading = MutableLiveData<Boolean>()

    abstract suspend fun run(params: Params): Type

    open operator fun invoke(
            scope: CoroutineScope,
            params: Params,
            onResult: (Type) -> Unit = {}
    ) {
        val backgroundJob = scope.async { run(params) }
        scope.launch {
            isLoading.postValue(true)
            onResult(backgroundJob.await())
            isLoading.postValue(false)
        }
    }
}