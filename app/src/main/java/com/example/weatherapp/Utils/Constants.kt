package com.weatherapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

object Constants {

    const val APP_ID: String = "2c50325f427689340a03ff16215d8fc4"
    const val BASE_URL: String = "http://api.openweathermap.org/data/"
    const val METRIC_UNIT: String = "metric"


    const val PREFERENCE_NAME = "WeatherAppPreference"
    const val WEATHER_RESPONSE_DATA = "weather_response_data"

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network      = connectivityManager.activeNetwork ?: return false
        val activeNetWork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}