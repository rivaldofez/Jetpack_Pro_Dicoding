package com.rivaldofez.moviers.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rivaldofez.moviers.data.source.TvShowDataSource
import com.rivaldofez.moviers.data.source.remote.response.RemoteDataSource
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowEntityResponse
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowItem

class FakeTvShowRepository(private val remoteDataSource: RemoteDataSource): TvShowDataSource {
    val isLoading = MutableLiveData<Boolean>()

    override fun getPopularTvShows(): LiveData<List<TvShowItem>> {
        isLoading.value = true
        val tvshowResults = MutableLiveData<List<TvShowItem>>()
        remoteDataSource.getPopularTvShow(object : RemoteDataSource.LoadPopularTvShowCallback{
            override fun onPopularTvShowsLoaded(tvshowResponse: List<TvShowItem>) {
                isLoading.value = false
                tvshowResults.postValue(tvshowResponse)
            }
        })
        return tvshowResults
    }

    override fun getDetailTvShow(tvShowId: String): LiveData<TvShowEntityResponse> {
        isLoading.value = true
        val detailTvShowResult = MutableLiveData<TvShowEntityResponse>()
        remoteDataSource.getDetailTvShow(object : RemoteDataSource.LoadDetailTvShowCallback{
            override fun onTvShowLoaded(tvShowEntityResponse: TvShowEntityResponse) {
                isLoading.value = false
                detailTvShowResult.postValue(tvShowEntityResponse)
            }
        }, tvShowId)

        return detailTvShowResult
    }
}