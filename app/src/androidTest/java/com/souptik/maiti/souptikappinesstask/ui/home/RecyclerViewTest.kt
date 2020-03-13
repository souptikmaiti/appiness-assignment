package com.souptik.maiti.souptikappinesstask.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.souptik.maiti.souptikappinesstask.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class RecyclerViewTest {

    @get: Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @get: Rule
    val activityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun test_fragment_launch(){
        onView(withId(R.id.rv_items)).check(matches(isDisplayed()))
    }

    @Test
    fun test_recycler_view_scroll(){
        onView(withId(R.id.rv_items))
            .perform(RecyclerViewActions.scrollToPosition<ItemAdapter.ItemViewHolder>(100))
    }

    @Test
    fun test_recycler_view_click_on_position(){
        val position: Int = 5
        onView(withId(R.id.rv_items))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ItemAdapter.ItemViewHolder>(position, click()))
    }
}