package com.souptik.maiti.souptikappinesstask.di.components

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.souptik.maiti.souptikappinesstask.AppinessApplication
import com.souptik.maiti.souptikappinesstask.data.remote.NetworkService
import com.souptik.maiti.souptikappinesstask.data.repository.ItemRepository
import com.souptik.maiti.souptikappinesstask.di.ApplicationContext
import com.souptik.maiti.souptikappinesstask.di.modules.ApplicationModule
import com.souptik.maiti.souptikappinesstask.utils.RxSchedulerProviders
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(appinessApplication: AppinessApplication)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getItemRepository(): ItemRepository

    fun getRxSchedulerProviders(): RxSchedulerProviders

    fun getCompositeDisposable(): CompositeDisposable
}