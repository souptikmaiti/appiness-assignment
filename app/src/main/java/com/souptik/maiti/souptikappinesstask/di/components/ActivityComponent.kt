package com.souptik.maiti.souptikappinesstask.di.components

import com.souptik.maiti.souptikappinesstask.di.ActivityScope
import com.souptik.maiti.souptikappinesstask.di.modules.ActivityModule
import com.souptik.maiti.souptikappinesstask.ui.home.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}