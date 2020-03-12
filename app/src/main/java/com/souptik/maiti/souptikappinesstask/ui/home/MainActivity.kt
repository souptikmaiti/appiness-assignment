package com.souptik.maiti.souptikappinesstask.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.souptik.maiti.souptikappinesstask.R
import com.souptik.maiti.souptikappinesstask.di.components.ActivityComponent
import com.souptik.maiti.souptikappinesstask.ui.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {
    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        addHomeFragment()
    }

    private fun addHomeFragment() {
        supportFragmentManager.findFragmentByTag(HomeFragment.TAG) ?: supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, HomeFragment.newInstance(), HomeFragment.TAG)
            .commitAllowingStateLoss()
    }

}
