package com.example.weatherapp.presentation.base

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    protected var _internetError = SingleLiveEvent<Boolean>()
    var internetError: LiveData<Boolean> = _internetError

    protected var _apiError = SingleLiveEvent<String>()
    var apiError: LiveData<String> = _apiError
}