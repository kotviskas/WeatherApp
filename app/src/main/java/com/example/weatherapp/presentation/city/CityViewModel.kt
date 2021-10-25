package com.example.weatherapp.presentation.city

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.usecase.GetWeatherByCityNameParams
import com.example.weatherapp.domain.usecase.GetWeatherByCityNameUseCase
import com.example.weatherapp.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class CityViewModel(
    private val getWeatherByCityNameUseCase: GetWeatherByCityNameUseCase,
    private val application: Application
) : BaseViewModel() {
    private var _weather: MutableLiveData<Weather> = MutableLiveData()
    val weather: LiveData<Weather> get() = _weather

    fun getWeather(cityName: String) {
        viewModelScope.launch {
            getWeatherSafeCall(cityName)
        }
    }

    private suspend fun getWeatherSafeCall(cityName: String) {
        if (hasInternetConnection(application)) {
            val result = getWeatherByCityNameUseCase.invoke(GetWeatherByCityNameParams(cityName))
            result
                .onFailure { _apiError.value = it.message }
                .onSuccess { _weather.value = it }
        } else {
            _internetError.call()
        }
    }
}