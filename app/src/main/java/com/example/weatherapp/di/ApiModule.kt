package com.example.weatherapp.di

import com.example.weatherapp.data.network.WeatherRepoApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    fun provideUseApi(retrofit: Retrofit): WeatherRepoApi {
        return retrofit.create(WeatherRepoApi::class.java)
    }
    single { provideUseApi(get()) }
}