package com.example.weatherapp.data.repository

import com.example.weatherapp.data.network.ResponseHandler
import com.example.weatherapp.data.network.WeatherRepoApi
import com.example.weatherapp.data.utils.toWeather
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherRepoApi: WeatherRepoApi,
    private val responseHandler: ResponseHandler
) : WeatherRepository {
    override suspend fun getWeatherByCityName(cityName: String): Result<Weather> {
        return try {
            responseHandler.handleSuccess(weatherRepoApi.getWeatherByCityName(cityName, "metric").toWeather())
        } catch (e: Exception) {
            responseHandler.handleException<Exception>(e)
        } as Result<Weather>
    }
}