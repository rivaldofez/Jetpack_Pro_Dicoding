package com.rivaldofez.moviers.ui.home

import android.widget.RatingBar
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.rivaldofez.moviers.R
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{
    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShows = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_trailer)).perform(ViewActions.scrollTo())

        val movieAttribute = listOf(R.id.tv_original_title,R.id.tv_overview,R.id.tv_date,R.id.tv_title,
            R.id.img_poster, R.id.img_backdrop, R.id.rating_movie, R.id.btn_trailer)

        for(idAttr in movieAttribute){
            onView(withId(idAttr)).check(matches(isDisplayed()))
        }

        onView(withId(R.id.tv_overview)).check(matches(withText(dummyMovies[0].overview)))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.tv_original_title)).check(matches(withText(dummyMovies[0].studio)))
        onView(withId(R.id.tv_date)).check(matches(withText(dummyMovies[0].date)))
        onView(withId(R.id.rating_movie)).check(matches(isAssignableFrom(RatingBar::class.java)))
    }

    @Test
    fun loadTrailerMovie(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_trailer)).perform(ViewActions.scrollTo())
        onView(withId(R.id.btn_trailer)).perform(click())
        onView(withId(R.id.web_trailer)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShows(){
        onView(withId(R.id.tvShowFragment)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size))
    }

    @Test
    fun loadDetailTvShow(){
        onView(withId(R.id.tvShowFragment)).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_trailer)).perform(ViewActions.scrollTo())

        val tvShowAttribute = listOf(R.id.tv_original_title,R.id.tv_overview,R.id.tv_date,R.id.tv_title,
            R.id.tv_status, R.id.tv_episode , R.id.img_poster, R.id.img_backdrop, R.id.rating_tvshow,
            R.id.btn_trailer)

        for(idAttr in tvShowAttribute){
            onView(withId(idAttr)).check(matches(isDisplayed()))
        }
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyTvShows[0].overview)))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShows[0].title)))
        onView(withId(R.id.tv_original_title)).check(matches(withText(dummyTvShows[0].studio)))
        onView(withId(R.id.tv_date)).check(matches(withText(dummyTvShows[0].date)))
        onView(withId(R.id.tv_status)).check(matches(withText(dummyTvShows[0].status)))
        onView(withId(R.id.tv_episode)).check(matches(withText("${dummyTvShows[0].episode}\nEPS")))
        onView(withId(R.id.rating_tvshow)).check(matches(isAssignableFrom(RatingBar::class.java)))
    }

    @Test
    fun loadTrailerTv(){
        onView(withId(R.id.tvShowFragment)).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_trailer)).perform(ViewActions.scrollTo())
        onView(withId(R.id.btn_trailer)).perform(click())
        onView(withId(R.id.web_trailer)).check(matches(isDisplayed()))
    }
}