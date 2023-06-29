package com.kartheek.apptesting

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @get : Rule
    var mActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testEditText() {
        // Find the EditText field by its ID or other appropriate matcher
        onView(withId(R.id.etUserName)).perform(clearText())

        // Perform an action on the EditText field, such as typing text
        val inputText = "Hello, World!"
        onView(withId(R.id.etUserName)).perform(typeText(inputText))

        // Close the soft keyboard
        closeSoftKeyboard()

        // Assert the expected behavior, such as the text in the EditText field.
       // In this case, it uses withText() matcher from ViewMatchers and takes the expected text (inputText) as a parameter.
        onView(withId(R.id.etUserName)).check(matches(withText(inputText)))
    }

    @Test
    fun testEditTextLength(){
        val invalidText = "12345" // Text with length less than 6
        val validText = "1234567" // Text with length greater than 6

        onView(withId(R.id.etPassword)).perform(clearText())
        onView(withId(R.id.etPassword)).perform(typeText(invalidText))
        closeSoftKeyboard()
        // Assert that the error message is displayed due to invalid text length
        onView(withId(R.id.tvErrorMessage)).check(matches(isDisplayed()))
        onView(withId(R.id.etPassword)).perform(clearText())
        onView(withId(R.id.etPassword)).perform(typeText(validText))
        closeSoftKeyboard()
        // Assert that the error message is not displayed as the text length is valid
        onView(withId(R.id.tvErrorMessage)).check(matches(not(isDisplayed())))
    }


}