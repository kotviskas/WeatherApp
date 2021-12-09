package com.example.weatherapp.domain.usecase

import com.example.weatherapp.domain.base.UseCase
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.repository.WeatherRepository

class GetWeatherByCityNameUseCase(private val weatherRepository: WeatherRepository) :
    UseCase<Result<Weather>, GetWeatherByCityNameParams> {
    override suspend fun invoke(params: GetWeatherByCityNameParams): Result<Weather> {
        return try {
            Result.success(weatherRepository.getWeatherByCityName(params.cityName))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

class GetWeatherByCityNameParams(val cityName: String)