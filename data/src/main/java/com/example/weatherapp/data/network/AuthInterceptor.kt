package com.example.weatherapp.data.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url().newBuilder().addQueryParameter("appid", apiKey).build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}