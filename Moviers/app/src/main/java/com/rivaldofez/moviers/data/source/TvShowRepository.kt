package com.rivaldofez.moviers.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rivaldofez.moviers.data.source.remote.response.RemoteDataSource
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowEntityResponse
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowItem

class TvShowRepository(private val remoteDataSource: RemoteDataSource): TvShowDataSource {
    companion object{
        @Volatile
        private var instance: TvShowRepository? = null
        fun getInstance(remoteDataSource: RemoteDataSource): TvShowRepository =
                instance ?: synchronized(this){
                    instance ?: TvShowRepository(remoteDataSource).apply { instance = this }
                }
    }

    override fun getPopularTvShows(): LiveData<List<TvShowItem>> {
        val tvshowResults = MutableLiveData<List<TvShowItem>>()
        remoteDataSource.getPopularTvShow(object : RemoteDataSource.LoadPopularTvShowCallback{
            override fun onPopularTvShowsLoaded(tvshowResponse: List<TvShowItem>) {
                tvshowResults.postValue(tvshowResponse)
            }
        })
        return tvshowResults
    }

    override fun getDetailTvShow(tvShowId: String): LiveData<TvShowEntityResponse> {
        val detailTvShowResult = MutableLiveData<TvShowEntityResponse>()
        remoteDataSource.getDetailTvShow(object : RemoteDataSource.LoadDetailTvShowCallback{
            override fun onTvShowLoaded(tvShowEntityResponse: TvShowEntityResponse) {
                detailTvShowResult.postValue(tvShowEntityResponse)
            }
        }, tvShowId)

        return detailTvShowResult
    }
}