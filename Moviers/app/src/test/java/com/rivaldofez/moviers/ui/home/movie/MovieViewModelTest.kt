package com.rivaldofez.moviers.ui.home.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.rivaldofez.moviers.data.source.MovieRepository
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieItem
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
class MovieViewModelTest {
    private lateinit var movieViewModel: MovieViewModel

    @get:Rule
    var instanceExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieObserver: Observer<List<MovieItem>>

    @Before
    fun setUp(){
        movieViewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getPopularMovies(){
        val dummyMovies = DataDummy.generatePopularMovies()
        val movies = MutableLiveData<List<MovieItem>>()
        movies.value = dummyMovies.results

        `when` (movieRepository.getPopularMovies()).thenReturn(movies)

        val movieEntities = movieViewModel.getPopularMovies().value
        verify(movieRepository).getPopularMovies()
        assertNotNull(movieEntities)
        assertEquals(3, movieEntities?.size)

        movieViewModel.getPopularMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies.results)
    }
}