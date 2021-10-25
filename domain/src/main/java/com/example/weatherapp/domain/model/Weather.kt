package com.example.weatherapp.domain.model

data class Weather(
    val temp: Double,
    val description: String,
    val humidity: Double,
    val speed: Double,
    val deg: Int,
    val pressure: Double,
    val icon: String
)