package com.souptik.maiti.souptikappinesstask.data.remote

import android.content.Context
import android.net.ConnectivityManager
import com.souptik.maiti.souptikappinesstask.utils.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response


class NetworkAvailableInterceptor(context: Context): Interceptor {
    private val applicationContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isNetworkAvailable()){
            throw NoInternetException("please connect to the internet")
        }
        return chain.proceed(chain.request())
    }

    private fun isNetworkAvailable():Boolean{
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        connectivityManager.activeNetworkInfo.also{
            return it !=null && it.isConnected
        }
    }
}
