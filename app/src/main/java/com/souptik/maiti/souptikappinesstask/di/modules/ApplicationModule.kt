package com.souptik.maiti.souptikappinesstask.di.modules

import android.app.Application
import android.content.Context
import com.souptik.maiti.souptikappinesstask.AppinessApplication
import com.souptik.maiti.souptikappinesstask.BuildConfig
import com.souptik.maiti.souptikappinesstask.data.remote.NetworkAvailableInterceptor
import com.souptik.maiti.souptikappinesstask.data.remote.NetworkService
import com.souptik.maiti.souptikappinesstask.data.remote.Networking
import com.souptik.maiti.souptikappinesstask.di.ApplicationContext
import com.souptik.maiti.souptikappinesstask.utils.RxSchedulerProviders
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: AppinessApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideRxSchedulerProviders(): RxSchedulerProviders = RxSchedulerProviders()

    @Provides
    fun provideNetworkAvailableInterceptor(): NetworkAvailableInterceptor = NetworkAvailableInterceptor(context = application)

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(
            baseUrl = BuildConfig.BASE_URL,
            cacheDir = application.cacheDir,
            cacheSize = 10 * 1024 * 1024, // 10MB
            interceptor = NetworkAvailableInterceptor(application)
        )
}