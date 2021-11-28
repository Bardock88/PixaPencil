package com.realtomjoney.pyxlmoose.activities.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.realtomjoney.pyxlmoose.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner


@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @get:Rule
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun uitest_activityMainFAB_isDisplayed() {
        onView(withId(R.id.floatingActionButton)).check(matches(isDisplayed()))
    }

    @Test
    fun uitest_fragmentNewCanvasRootLayout_isNotDisplayed() {
        onView(withId(R.id.fragmentNewCanvas_rootLayout)).check(doesNotExist())
    }

    @Test
    fun uitest_fragmentNewCanvasProjectTitleTextInputEditText_isNotDisplayed() {
        onView(withId(R.id.fragmentNewCanvas_projectTitleTextInputEditText)).check(doesNotExist())
    }

    @Test
    fun uitest_fragmentNewCanvasProjectTitleTextInputLayout_isNotDisplayed() {
        onView(withId(R.id.fragmentNewCanvas_projectTitleTextInputLayout)).check(doesNotExist())
    }

    @Test
    fun uitest_fragmentNewCanvasSpanCountTextInputEditText_isNotDisplayed() {
        onView(withId(R.id.fragmentNewCanvas_spanCountTextInputEditText)).check(doesNotExist())
    }

    @Test
    fun uitest_fragmentNewCanvasSpanCountTextInputLayout_isNotDisplayed() {
        onView(withId(R.id.fragmentNewCanvas_spanCountTextInputLayout)).check(doesNotExist())
    }

    @Test
    fun uitest_fragmentNewCanvasDoneButton_isNotDisplayed() {
        onView(withId(R.id.fragmentNewCanvas_doneButton)).check(doesNotExist())
    }

    private fun createNewProject() {
        onView(withId(R.id.floatingActionButton)).perform(click())
        onView(withId(R.id.fragmentNewCanvas_projectTitleTextInputEditText)).perform(replaceText("Untitled Project"))
        onView(withId(R.id.fragmentNewCanvas_spanCountTextInputEditText)).perform(replaceText("5"))
        onView(withId(R.id.fragmentNewCanvas_doneButton)).perform(click())
    }

    @Test
    fun uitest_fragmentNewCanvasProjectTitleTextInputEditText_isNotDisplayed_after_fragmentNewCanvasDoneButton_isPressed() {
        createNewProject()
        onView(withId(R.id.fragmentNewCanvas_projectTitleTextInputEditText)).check(doesNotExist())
    }

    @Test
    fun uitest_fragmentNewCanvasProjectTitleTextInputLayout_isNotDisplayed_after_fragmentNewCanvasDoneButton_isPressed() {
        createNewProject()
        onView(withId(R.id.fragmentNewCanvas_projectTitleTextInputLayout)).check(doesNotExist())
    }

    @Test
    fun uitest_fragmentNewCanvasSpanCountTextInputEditText_isNotDisplayed_after_fragmentNewCanvasDoneButton_isPressed() {
        createNewProject()
        onView(withId(R.id.fragmentNewCanvas_spanCountTextInputEditText)).check(doesNotExist())
    }

    @Test
    fun uitest_fragmentNewCanvasSpanCountTextInputLayout_isNotDisplayed_after_fragmentNewCanvasDoneButton_isPressed() {
        createNewProject()
        onView(withId(R.id.fragmentNewCanvas_spanCountTextInputLayout)).check(doesNotExist())
    }

    @Test
    fun uitest_fragmentNewCanvasDoneButton_isNotDisplayed_after_fragmentNewCanvasDoneButton_isPressed() {
        createNewProject()
        onView(withId(R.id.fragmentNewCanvas_doneButton)).check(doesNotExist())
    }

    @Test
    fun uitest_recentCreationsRecyclerView_isDisplayed() {
        onView(withId(R.id.recentCreationsRecyclerView)).check(matches(isDisplayed()))
    }
}
