package com.rivaldofez.moviers.ui.home.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.rivaldofez.moviers.data.source.TvShowRepository
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowItem
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
class TvShowViewModelTest {
    private lateinit var tvShowViewModel: TvShowViewModel

    @get:Rule
    var instanceExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvSHowRepository: TvShowRepository

    @Mock
    private lateinit var tvShowObserver: Observer<List<TvShowItem>>

    @Before
    fun setUp(){
        tvShowViewModel = TvShowViewModel(tvSHowRepository)
    }

    @Test
    fun getPopularTvShows(){
        val dummyTvShows = DataDummy.generatePopularTvShows()
        val tvshows = MutableLiveData<List<TvShowItem>>()

        tvshows.value = dummyTvShows.results

        `when` (tvSHowRepository.getPopularTvShows()).thenReturn(tvshows)
        val tvshowEntities = tvShowViewModel.getPopularTvShows().value
        verify(tvSHowRepository).getPopularTvShows()
        assertNotNull(tvshowEntities)
        assertEquals(3, tvshowEntities?.size)

        tvShowViewModel.getPopularTvShows().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShows.results)
    }
}