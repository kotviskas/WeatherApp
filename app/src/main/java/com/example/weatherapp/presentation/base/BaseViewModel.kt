package com.example.weatherapp.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    private var _internetError = SingleLiveEvent<Throwable>()
    var internetError: LiveData<Throwable> = _internetError

    fun <T> Result<T>.onFailure(action: (exception: Throwable) -> Unit): Result<T> {
        exceptionOrNull()?.let {
            action(it)
            _internetError.value = it
        }
        return this
    }
}