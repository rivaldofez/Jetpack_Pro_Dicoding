package com.rivaldofez.moviers.ui.home.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rivaldofez.moviers.data.source.TvShowRepository
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowItem

class TvShowViewModel(private val tvShowRepository: TvShowRepository): ViewModel() {
    fun getPopularTvShows(): LiveData<List<TvShowItem>> = tvShowRepository.getPopularTvShows()

    fun getLoadingStatus(): LiveData<Boolean> = tvShowRepository.isLoading
}