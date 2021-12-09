package com.example.weatherapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CloudsDto(
    val all: Int?
)