package com.example.weatherapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CountryTimeInfoDto(
    val country: String?,
    val id: Int?,
    val sunrise: Int?,
    val sunset: Int?,
    val type: Int?
)