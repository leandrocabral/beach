package br.com.leandroid.beachs.presentation.beach

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import br.com.leandroid.beach.R
import br.com.leandroid.beachs.presentation.home.HomeActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test

class BeachScreenTest {

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun show_beach_list_when_open() {
        launchFragmentInContainer<BeachFragment>()

        onView(ViewMatchers.withText("Praia do Centro"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun show_beach_list_when_open_two_test() {
        launchFragmentInContainer<BeachFragment>()

        onView(
            allOf(
                ViewMatchers.withText("Praia do Centro"),
                withId(R.id.name_card_beach)
            )
        )
            .check(matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun show_beach_list_when_open_three_test() {
        launchFragmentInContainer<BeachFragment>()

        onView(withId(R.id.beach_recyclerview))
            .check(matches(allOf(beachListMatchesCustom(0,"Praia do Centro"),isDisplayed())))

    }

    fun beachListMatchesCustom(position: Int,descriptionName:String): Matcher<View> {
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description?) {
                description?.appendText("RecyclerView with item count: $position")
            }

            override fun matchesSafely(item: RecyclerView?): Boolean {
                val viewViewHolder = item?.findViewHolderForAdapterPosition(position)?.itemView
                val descriptionTextView = viewViewHolder?.findViewById<TextView>(R.id.name_card_beach)
                val isItemDescription = descriptionTextView?.text.toString().equals(descriptionName)

                return isItemDescription
            }
        }
    }

}