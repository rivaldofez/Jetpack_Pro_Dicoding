package com.rivaldofez.moviers.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.ramijemli.percentagechartview.PercentageChartView
import com.rivaldofez.moviers.R
import com.rivaldofez.moviers.utils.*
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest{
    private val dummyDetailMovie = DataDummy.generateDetailMovie()
    private val dummyDetailTvShow = DataDummy.generateDetailTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies(){
        //check recylerview and scroll to last data from api
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20))
    }

    @Test
    fun loadDetailMovie(){
        //Click on first item
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        //check displayed item
        var movieAttribute = listOf(R.id.img_backdrop, R.id.img_poster, R.id.chart_popularity,
            R.id.tv_date, R.id.tv_duration)
        for(idAttr in movieAttribute){
            onView(withId(idAttr)).check(matches(isDisplayed()))
        }

        //scroll page to end
        onView(withId(R.id.btn_home_page)).perform(ViewActions.scrollTo())

        //check next displayed item after scrolling
        movieAttribute = listOf(R.id.tv_synopsis, R.id.tv_synopsis_title, R.id.tv_more_title,
            R.id.tv_original_title, R.id.tv_original, R.id.tv_genre_title, R.id.ll_genre, R.id.tv_language_title,
            R.id.ll_language, R.id.tv_homepage_title, R.id.tv_homepage, R.id.tv_budget, R.id.tv_budget_title,
            R.id.tv_revenue_title, R.id.tv_revenue, R.id.tv_status_title, R.id.tv_status, R.id.btn_home_page)

        for(idAttr in movieAttribute){
            onView(withId(idAttr)).check(matches(isDisplayed()))
        }

    }

    @Test
    fun loadHomePageMovies(){
        //check web view movies home page
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_home_page)).perform(ViewActions.scrollTo())
        onView(withId(R.id.btn_home_page)).perform(click())
        onView(withId(R.id.web_trailer)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShows(){
        //check recylerview and scroll to last data from api
        onView(withId(R.id.nav_tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20))
    }

    @Test
    fun loadDetailTvShow(){
        //Click on first item
        onView(withId(R.id.nav_tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        //check displayed item
        var tvShowAttribute = listOf(R.id.img_backdrop, R.id.img_poster, R.id.chart_popularity,
            R.id.tv_date, R.id.tv_latest_episode)
        for(idAttr in tvShowAttribute){
            onView(withId(idAttr)).check(matches(isDisplayed()))
        }

        //scroll page to end
        onView(withId(R.id.btn_home_page)).perform(ViewActions.scrollTo())

        //check next displayed item after scrolling
        tvShowAttribute = listOf(R.id.tv_synopsis, R.id.tv_synopsis_title, R.id.tv_more_title,
            R.id.tv_original_title, R.id.tv_original, R.id.tv_genre_title, R.id.ll_genre, R.id.tv_language_title,
            R.id.ll_language, R.id.tv_season_title, R.id.tv_season, R.id.tv_episode_title, R.id.tv_episode,
            R.id.tv_homepage_title, R.id.tv_homepage, R.id.tv_status, R.id.btn_home_page)

        for(idAttr in tvShowAttribute){
            onView(withId(idAttr)).check(matches(isDisplayed()))
        }
    }

    @Test
    fun loadHomepageTv(){
        //check web view movies home page
        onView(withId(R.id.nav_tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_home_page)).perform(ViewActions.scrollTo())
        onView(withId(R.id.btn_home_page)).perform(click())
        onView(withId(R.id.web_trailer)).check(matches(isDisplayed()))
    }
}