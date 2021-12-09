package com.example.weatherapp.di

import com.example.weatherapp.domain.usecase.GetWeatherByCityNameUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetWeatherByCityNameUseCase(get()) }
}