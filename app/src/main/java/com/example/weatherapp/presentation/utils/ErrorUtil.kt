package com.example.weatherapp.presentation.utils

import android.content.Context
import android.widget.Toast
import com.example.weatherapp.R
import java.net.UnknownHostException

object ErrorUtil {
    fun handleError(context: Context, throwable: Throwable) {
        val message = if (throwable is UnknownHostException) {
            context.getString(R.string.no_internet_error)
        } else {
            throwable.message.toString()
        }
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}