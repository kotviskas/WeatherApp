package com.example.weatherapp.data.utils

import com.example.weatherapp.data.model.WeatherResponseDto
import com.example.weatherapp.domain.model.Weather

fun WeatherResponseDto.toWeather(): Weather = Weather(
    temp = main?.temp ?: 0.toDouble(),
    description = weather?.get(0)?.description ?: "description",
    humidity = main?.humidity ?: 0.toDouble(),
    speed = wind?.speed ?: 0.toDouble(),
    deg = wind?.deg ?: 0,
    pressure = main?.pressure ?: 0.toDouble(),
    icon = getIconUrl(weather?.get(0)?.icon)
)

fun getIconUrl(icon: String?): String {
    return if (icon == null) {
        "icon"
    } else {
        "https://openweathermap.org/img/wn/$icon@2x.png"
    }
}