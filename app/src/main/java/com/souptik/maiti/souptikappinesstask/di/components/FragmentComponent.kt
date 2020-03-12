package com.souptik.maiti.souptikappinesstask.di.components

import com.souptik.maiti.souptikappinesstask.di.FragmentScope
import com.souptik.maiti.souptikappinesstask.di.modules.ApplicationModule
import com.souptik.maiti.souptikappinesstask.di.modules.FragmentModule
import com.souptik.maiti.souptikappinesstask.ui.home.HomeFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(fragment: HomeFragment)
}