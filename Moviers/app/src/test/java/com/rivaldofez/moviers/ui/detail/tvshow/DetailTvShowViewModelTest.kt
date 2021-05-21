package com.rivaldofez.moviers.ui.detail.tvshow

import com.rivaldofez.moviers.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailTvShowViewModelTest {
    private lateinit var detailTvShowViewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShow()[8]
    private val dummyTvShowid = dummyTvShow.id

    @Before
    fun setUp(){
        detailTvShowViewModel = DetailTvShowViewModel()
    }

    @Test
    fun getTvShow() {
        detailTvShowViewModel.setCurrentTvShow(dummyTvShowid)
        val resultTvShow = detailTvShowViewModel.getTvShow()
        assertNotNull(resultTvShow)
        assertEquals(dummyTvShow, resultTvShow)
        assertEquals(dummyTvShow.id, resultTvShow.id)
        assertEquals(dummyTvShow.title, resultTvShow.title)
        assertEquals(dummyTvShow.posterPath, resultTvShow.posterPath)
        assertEquals(dummyTvShow.backdropPath, resultTvShow.backdropPath)
        assertEquals(dummyTvShow.date, resultTvShow.date)
        assertEquals(dummyTvShow.overview, resultTvShow.overview)
        assertEquals(dummyTvShow.rating, resultTvShow.rating)
        assertEquals(dummyTvShow.studio, resultTvShow.studio)
        assertEquals(dummyTvShow.trailerUrl, resultTvShow.trailerUrl)
        assertEquals(dummyTvShow.episode, resultTvShow.episode)
        assertEquals(dummyTvShow.status, resultTvShow.status)
    }
}