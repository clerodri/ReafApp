package com.clerodri.memitoapp.ui.todo

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.clerodri.memitoapp.R
import com.clerodri.memitoapp.launchFragmentInHiltContainer
import com.clerodri.memitoapp.ui.record.RecordFragment
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class TodoFragmentTest {

    @get:Rule(order = 0)
    var hitRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        hitRule.inject()
    }

    @Test
    fun test_isFragmentOnView() {
        launchFragmentInHiltContainer<TodoFragment>()

        onView(withId(R.id.todoFragment)).check(matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.tvTitle)).check(matches(withText(R.string.list_to_do)))
    }
}