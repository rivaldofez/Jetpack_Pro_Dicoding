package com.rivaldofez.moviers.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.rivaldofez.moviers.data.source.remote.response.RemoteDataSource
import com.rivaldofez.moviers.utils.DataDummy
import com.rivaldofez.moviers.utils.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val moviesResponse = DataDummy.generatePopularMovies()
    private val movieId = moviesResponse.results[0].id.toString()

    private val detailMovieResponse = DataDummy.generateDetailMovie()
    private val detailMovieId = detailMovieResponse.id.toString()

    @Test
    fun getPopularMovies(){
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadPopularMoviesCallback)
                .onPopularMoviesLoaded(moviesResponse.results)
            null
        }.`when`(remote).getPopularMovies(any())

        val moviesEntities = LiveDataTestUtil.getValue(movieRepository.getPopularMovies())
        verify(remote).getPopularMovies(any())

        assertNotNull(moviesEntities)
        assertEquals(moviesResponse.results.size.toLong(), moviesEntities.size.toLong())
    }

    @Test
    fun getDetailMovie(){
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadDetailMovieCallback)
                .onMovieLoaded(detailMovieResponse)
            null
        }.`when`(remote).getDetailMovie(any(), eq(movieId))

        val movieEntity = LiveDataTestUtil.getValue(movieRepository.getDetailMovie(detailMovieId))

        verify(remote).getDetailMovie(any(), eq(movieId))

        assertNotNull(movieEntity)
        assertEquals(detailMovieResponse, movieEntity)
    }

}