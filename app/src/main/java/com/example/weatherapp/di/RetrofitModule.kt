package com.example.weatherapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

val retrofitModule = module {

    fun provideJson() = Json {
        ignoreUnknownKeys = true
        encodeDefaults = false
    }

    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(json: Json, client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("BuildConfig.BASE_URL")
            .addConverterFactory(
                json.asConverterFactory(
                    "application/json".toMediaType()
                )
            )
            .client(client)
            .build()

    single { provideJson() }
    single { provideHttpClient() }
    single { provideRetrofit(get(), get()) }
}