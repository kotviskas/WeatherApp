package com.example.weatherapp.data.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ExceptionInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        try {
            return chain.proceed(request)
        } catch (e: Exception) {
            when (e) {
                is SocketTimeoutException -> {
                    throw SocketTimeoutException("Timeout - Please check your internet connection")
                }
                is UnknownHostException -> {
                    throw UnknownHostException("Unable to make a connection. Please check your internet")
                }
                is IOException -> {
                    throw IOException("Server is unreachable, please try again later.")
                }
            }
            throw e
        }
    }
}
