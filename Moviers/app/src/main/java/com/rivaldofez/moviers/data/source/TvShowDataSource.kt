package com.rivaldofez.moviers.data.source

import androidx.lifecycle.LiveData
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowEntityResponse
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowItem

interface TvShowDataSource {
    fun getPopularTvShows(): LiveData<List<TvShowItem>>

    fun getDetailTvShow(tvShowId: String): LiveData<TvShowEntityResponse>
}