package com.rivaldofez.moviers.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.rivaldofez.moviers.data.source.remote.response.RemoteDataSource
import com.rivaldofez.moviers.utils.DataDummy
import com.rivaldofez.moviers.utils.LiveDataTestUtil
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class TvShowRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val tvShowRepository = FakeTvShowRepository(remote)

    private val tvShowsResponses = DataDummy.generatePopularTvShows()
    private val tvShowId = tvShowsResponses.results[0].id.toString()

    private val detailTvShowResponse = DataDummy.generateDetailTvShow()
    private val detailTvShowId = detailTvShowResponse.id.toString()

    @Test
    fun getPopularTvShows(){
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadPopularTvShowCallback)
                .onPopularTvShowsLoaded(tvShowsResponses.results)
            null
        }.`when`(remote).getPopularTvShow(any())

        val tvShowsEntities = LiveDataTestUtil.getValue(tvShowRepository.getPopularTvShows())
        verify(remote).getPopularTvShow(any())

        Assert.assertNotNull(tvShowsEntities)
        Assert.assertEquals(tvShowsResponses.results.size.toLong(), tvShowsEntities.size.toLong())
    }

    @Test
    fun getDetailTvShow(){
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadDetailTvShowCallback)
                .onTvShowLoaded(detailTvShowResponse)
            null
        }.`when`(remote).getDetailTvShow(any(), eq(tvShowId))

        val tvShowEntity = LiveDataTestUtil.getValue(tvShowRepository.getDetailTvShow(detailTvShowId))

        verify(remote).getDetailTvShow(any(), eq(detailTvShowId))

        Assert.assertNotNull(tvShowEntity)
        Assert.assertEquals(detailTvShowResponse, tvShowEntity)
    }

}