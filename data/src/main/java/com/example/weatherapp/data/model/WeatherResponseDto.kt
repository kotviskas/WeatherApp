package com.example.weatherapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponseDto(
    val base: String?,
    val clouds: CloudsDto?,
    val cod: Int?,
    val coord: CoordDto?,
    val dt: Int?,
    val id: Int?,
    val main: WeatherMainInfoDto?,
    val name: String?,
    val sys: CountryTimeInfoDto?,
    val timezone: Int?,
    val visibility: Int?,
    val weather: List<WeatherDto>?,
    val wind: WindDto?
)