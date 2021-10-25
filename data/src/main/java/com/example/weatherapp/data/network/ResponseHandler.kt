package com.example.weatherapp.data.network

import retrofit2.HttpException
import java.net.SocketTimeoutException

enum class ErrorCodes(val code: Int) {
    SocketTimeOut(-1)
}

open class ResponseHandler {
    fun <T : Any> handleSuccess(data: T): Result<T> {
        return Result.success(data)
    }

    fun <T : Any> handleException(e: Exception): Result<T> {
        return when (e) {
            is HttpException -> Result.failure(Exception(getErrorMessage(e.code())))
            is SocketTimeoutException -> Result.failure(
                Exception(
                    getErrorMessage(ErrorCodes.SocketTimeOut.code)
                )
            )
            else -> Result.failure(Exception(e.message))
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            ErrorCodes.SocketTimeOut.code -> "Timeout"
            401 -> "Unauthorized"
            404 -> "Not found"
            else -> "Something went wrong"
        }
    }
}