package com.example.weatherapp.data.repository

import com.example.weatherapp.data.network.WeatherRepoApi
import com.example.weatherapp.data.utils.toWeather
import com.example.weatherapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherRepoApi: WeatherRepoApi
) : WeatherRepository {
    override suspend fun getWeatherByCityName(cityName: String) =
        weatherRepoApi.getWeatherByCityName(cityName, "metric").toWeather()
}