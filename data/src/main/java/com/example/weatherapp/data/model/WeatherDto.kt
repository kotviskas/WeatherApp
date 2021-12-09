package com.example.weatherapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    val description: String?,
    val icon: String?,
    val id: Int?,
    val main: String?
)