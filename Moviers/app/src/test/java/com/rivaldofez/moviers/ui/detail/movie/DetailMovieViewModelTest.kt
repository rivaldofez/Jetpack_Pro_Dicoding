package com.rivaldofez.moviers.ui.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.rivaldofez.moviers.data.source.MovieRepository
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieEntityResponse
import com.rivaldofez.moviers.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private lateinit var detailMovieViewModel: DetailMovieViewModel
    private val dummyMovie: MovieEntityResponse = DataDummy.generateDetailMovie()
    private val dummyMovieid: String = dummyMovie.id.toString()

    @get:Rule
    var instanceExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var detailMovieObserver: Observer<MovieEntityResponse>

    @Before
    fun setUp(){
        detailMovieViewModel = DetailMovieViewModel(movieRepository)
        detailMovieViewModel.setCurrentMovie(dummyMovieid)
    }


    @Test
    fun getDetailMovie(){
        val movie = MutableLiveData<MovieEntityResponse>()
        movie.value = dummyMovie

        `when` (movieRepository.getDetailMovie(dummyMovieid)).thenReturn(movie)

        val movieEntity = detailMovieViewModel.getDetailMovie().value as MovieEntityResponse
        verify(movieRepository).getDetailMovie(dummyMovieid)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie, movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.originalLanguage, movieEntity.originalLanguage)
        assertEquals(dummyMovie.imdbId, movieEntity.imdbId)
        assertEquals(dummyMovie.video, movieEntity.video)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.backdropPath, movieEntity.backdropPath)
        assertEquals(dummyMovie.revenue, movieEntity.revenue)
        assertEquals(dummyMovie.genres, movieEntity.genres)
        assertEquals(dummyMovie.popularity, movieEntity.popularity, 0.0001)
        assertEquals(dummyMovie.productionCountries, movieEntity.productionCountries)
        assertEquals(dummyMovie.voteCount, movieEntity.voteCount)
        assertEquals(dummyMovie.budget, movieEntity.budget)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.runtime, movieEntity.runtime)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)
        assertEquals(dummyMovie.spokenLanguages, movieEntity.spokenLanguages)
        assertEquals(dummyMovie.productionCountries, movieEntity.productionCountries)
        assertEquals(dummyMovie.productionCompanies, movieEntity.productionCompanies)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.homepage, movieEntity.homepage)
        assertEquals(dummyMovie.status, movieEntity.status)

        detailMovieViewModel.getDetailMovie().observeForever(detailMovieObserver)
        verify(detailMovieObserver).onChanged(dummyMovie)
    }
}