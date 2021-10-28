package com.example.weatherapp.data.network

import com.example.weatherapp.data.model.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherRepoApi {
    @GET("weather")
    suspend fun getWeatherByCityName(@Query("q") cityName: String, @Query("units") unit: String): WeatherResponseDto
}