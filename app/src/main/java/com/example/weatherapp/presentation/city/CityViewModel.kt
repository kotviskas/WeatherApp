package com.example.weatherapp.presentation.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.usecase.GetWeatherByCityNameParams
import com.example.weatherapp.domain.usecase.GetWeatherByCityNameUseCase
import com.example.weatherapp.presentation.base.BaseViewModel
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class CityViewModel(
    private val getWeatherByCityNameUseCase: GetWeatherByCityNameUseCase
) : BaseViewModel() {
    private var _weather: MutableLiveData<Weather> = MutableLiveData()
    val weather: LiveData<Weather> get() = _weather

    fun getWeather(cityName: String) {
        viewModelScope.launch {
            getWeatherSafeCall(cityName)
        }
    }

    private suspend fun getWeatherSafeCall(cityName: String) {
        getWeatherByCityNameUseCase.invoke(GetWeatherByCityNameParams(cityName))
            .onFailure {
                if (it is UnknownHostException) {
                    _internetError.call()
                } else {
                    _apiError.value = it.message
                }
            }
            .onSuccess { _weather.value = it }
    }
}