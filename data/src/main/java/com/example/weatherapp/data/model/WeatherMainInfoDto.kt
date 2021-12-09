package com.example.weatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherMainInfoDto(
    @SerialName("feels_like")
    val feelsLike: Double?,
    val humidity: Double?,
    val pressure: Double?,
    val temp: Double?,
    @SerialName("temp_max")
    val tempMax: Double?,
    @SerialName("temp_min")
    val tempMin: Double?
)