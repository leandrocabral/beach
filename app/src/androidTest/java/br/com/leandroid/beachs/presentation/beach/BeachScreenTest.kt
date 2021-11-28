package br.com.leandroid.beachs.presentation.beach

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import br.com.leandroid.beachs.presentation.home.HomeActivity
import org.junit.Rule
import org.junit.Test

class BeachScreenTest {

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun show_beach_list_when_open() {
         val fragmentArgs = Bundle()

        launchFragmentInContainer<BeachFragment>()

        onView(ViewMatchers.withText("Praia Costa Azul"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}