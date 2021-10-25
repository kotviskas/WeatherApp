package com.example.weatherapp.di

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.R
import com.example.weatherapp.data.network.AuthInterceptor
import com.example.weatherapp.data.network.ResponseHandler
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

val retrofitModule = module {

    fun provideJson() = Json {
        ignoreUnknownKeys = true
        encodeDefaults = false
    }

    fun provideHttpClient(
        authInterceptor: AuthInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder().addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(json: Json, client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(
                json.asConverterFactory(
                    "application/json".toMediaType()
                )
            )
            .client(client)
            .build()

    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        return logger
    }

    single { provideJson() }
    single { provideHttpClient(get(), get()) }
    single { provideRetrofit(get(), get()) }
    single { AuthInterceptor(androidContext().getString(R.string.weather_api_key)) }
    single { ResponseHandler() }
    factory { provideLoggingInterceptor() }
}