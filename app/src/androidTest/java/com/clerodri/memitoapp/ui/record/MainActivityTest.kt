package com.clerodri.memitoapp.ui.record


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.clerodri.memitoapp.R
import com.clerodri.memitoapp.launchFragmentInHiltContainer
import com.clerodri.memitoapp.ui.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@HiltAndroidTest
class MainActivityTest {


    @get:Rule(order = 0)
    var hitRule = HiltAndroidRule(this)


    @Before
    fun setUp() {
        hitRule.inject()
    }


    @Test
    fun testLaunchFragmentInHiltContainer() {
        launchFragmentInHiltContainer<RecordFragment>()
        onView(withId(R.id.recordFragment))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main))
            .check(matches(isDisplayed()))

        onView(withId(R.id.bottom_bar))
            .check(matches(isEnabled()))

    }


}


