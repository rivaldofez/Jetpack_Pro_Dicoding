package com.rivaldofez.moviers.ui.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.rivaldofez.moviers.data.source.TvShowRepository
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowEntityResponse
import com.rivaldofez.moviers.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {
    private lateinit var detailTvShowViewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDetailTvShow()
    private val dummyTvShowId: String = dummyTvShow.id.toString()

    @get:Rule
    var instanceExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvShowRepository: TvShowRepository

    @Mock
    private lateinit var detailTvShowObserver: Observer<TvShowEntityResponse>

    @Before
    fun setUp(){
        detailTvShowViewModel = DetailTvShowViewModel(tvShowRepository)
        detailTvShowViewModel.setCurrentTvShow(dummyTvShowId)
    }


    @Test
    fun getDetailTvShow(){
        val tvshow = MutableLiveData<TvShowEntityResponse>()
        tvshow.value = dummyTvShow

        Mockito.`when`(tvShowRepository.getDetailTvShow(dummyTvShowId)).thenReturn(tvshow)

        val tvShowEntity = detailTvShowViewModel.getDetailTvShow().value as TvShowEntityResponse
        verify(tvShowRepository).getDetailTvShow(dummyTvShowId)
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow, tvShowEntity)
        assertEquals(dummyTvShow.id, tvShowEntity.id)
        assertEquals(dummyTvShow.originalLanguage, tvShowEntity.originalLanguage)
        assertEquals(dummyTvShow.numberOfEpisodes, tvShowEntity.numberOfEpisodes)
        assertEquals(dummyTvShow.networks, tvShowEntity.networks)
        assertEquals(dummyTvShow.type, tvShowEntity.type)
        assertEquals(dummyTvShow.backdropPath, tvShowEntity.backdropPath)
        assertEquals(dummyTvShow.genres, tvShowEntity.genres)
        assertEquals(dummyTvShow.popularity, tvShowEntity.popularity, 0.0001)
        assertEquals(dummyTvShow.productionCompanies, tvShowEntity.productionCompanies)
        assertEquals(dummyTvShow.productionCountries, tvShowEntity.productionCountries)
        assertEquals(dummyTvShow.voteAverage, tvShowEntity.voteAverage)
        assertEquals(dummyTvShow.voteCount, tvShowEntity.voteCount)
        assertEquals(dummyTvShow.firstAirDate, tvShowEntity.firstAirDate)
        assertEquals(dummyTvShow.overview, tvShowEntity.overview)
        assertEquals(dummyTvShow.seasons, tvShowEntity.seasons)
        assertEquals(dummyTvShow.posterPath, tvShowEntity.posterPath)
        assertEquals(dummyTvShow.status, tvShowEntity.status)
        assertEquals(dummyTvShow.homepage, tvShowEntity.homepage)
        assertEquals(dummyTvShow.episodeRunTime, tvShowEntity.episodeRunTime)

        detailTvShowViewModel.getDetailTvShow().observeForever(detailTvShowObserver)
        verify(detailTvShowObserver).onChanged(dummyTvShow)
    }
}