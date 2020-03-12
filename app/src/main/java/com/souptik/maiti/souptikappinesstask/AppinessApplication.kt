package com.souptik.maiti.souptikappinesstask

import android.app.Application
import com.souptik.maiti.souptikappinesstask.di.components.ApplicationComponent
import com.souptik.maiti.souptikappinesstask.di.components.DaggerApplicationComponent
import com.souptik.maiti.souptikappinesstask.di.modules.ApplicationModule

class AppinessApplication: Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}