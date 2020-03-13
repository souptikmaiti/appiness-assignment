package com.souptik.maiti.souptikappinesstask.ui.home

import android.view.View
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.souptik.maiti.souptikappinesstask.R
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class HomeFragmentTest {

    @get: Rule
    val activityRule: ActivityTestRule<MainActivity> = ActivityTestRule<MainActivity>(MainActivity::class.java)

    private var mActivity: MainActivity? = null

    @Before
    fun setUp() {
        mActivity = activityRule.activity

    }

    @Test
    fun test_fragment(){
        val fragment: HomeFragment = HomeFragment.newInstance()
        mActivity!!.supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commitAllowingStateLoss()
        InstrumentationRegistry.getInstrumentation().waitForIdleSync()
        val view: View? = fragment.view?.findViewById(R.id.rv_items)
        assertNotNull(view)
    }

    @After
    fun tearDown() {
        mActivity = null
    }
}