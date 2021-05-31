package com.rivaldofez.moviers.ui.detail.movie

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest {
    private lateinit var detailMovieViewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[4]
    private val dummyMovieid = dummyMovie.id

    @Before
    fun setUp(){
        detailMovieViewModel = DetailMovieViewModel()
    }

    @Test
    fun getMovie() {
        detailMovieViewModel.setCurrentMovie(dummyMovieid)
        val resultMovie = detailMovieViewModel.getMovie()
        assertNotNull(resultMovie)
        assertEquals(dummyMovie, resultMovie)
        assertEquals(dummyMovie.id, resultMovie.id)
        assertEquals(dummyMovie.title, resultMovie.title)
        assertEquals(dummyMovie.posterPath, resultMovie.posterPath)
        assertEquals(dummyMovie.backdropPath, resultMovie.backdropPath)
        assertEquals(dummyMovie.date, resultMovie.date)
        assertEquals(dummyMovie.overview, resultMovie.overview)
        assertEquals(dummyMovie.rating, resultMovie.rating)
        assertEquals(dummyMovie.studio, resultMovie.studio)
        assertEquals(dummyMovie.trailerUrl, resultMovie.trailerUrl)
    }
}