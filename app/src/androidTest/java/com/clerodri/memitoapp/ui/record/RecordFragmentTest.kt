package com.clerodri.memitoapp.ui.record

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.clerodri.memitoapp.R
import com.clerodri.memitoapp.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.CoreMatchers
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.regex.Matcher

@HiltAndroidTest
class RecordFragmentTest {
    private val STATIC_INPUT_TEXT = "HELLO FROM TEST"
    @get:Rule(order = 0)
    var hitRule = HiltAndroidRule(this)
    @Before
    fun setUp() {
        hitRule.inject()
    }


    @Test
    fun test_isFragmentOnView(){
        launchFragmentInHiltContainer<RecordFragment>()
        onView(withId(R.id.recordFragment)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).check(matches(isDisplayed()))
        onView(withId(R.id.ivRecord)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRecord)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isBtnClearWorking(){

        launchFragmentInHiltContainer<RecordFragment>()
        onView(withId(R.id.tvRecord)).perform(setTextInTextView(STATIC_INPUT_TEXT))
        onView(withId(R.id.btn_clear)).perform(click())
        onView(withId(R.id.tvRecord)).check(matches( withText("")))

    }

    fun setTextInTextView(value: String): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): org.hamcrest.Matcher<View> {
                return CoreMatchers.allOf(isDisplayed(), ViewMatchers.isAssignableFrom(TextView::class.java))
            }

            override fun perform(uiController: UiController, view: View) {
                (view as TextView).text = value
            }

            override fun getDescription(): String {
                return ""
            }
        }
    }
}