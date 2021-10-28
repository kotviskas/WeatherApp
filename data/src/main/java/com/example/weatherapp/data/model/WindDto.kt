package com.example.weatherapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WindDto(
    val deg: Int?,
    val speed: Double?
)