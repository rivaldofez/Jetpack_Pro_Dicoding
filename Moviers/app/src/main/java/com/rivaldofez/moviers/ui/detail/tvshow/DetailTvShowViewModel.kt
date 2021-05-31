package com.rivaldofez.moviers.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rivaldofez.moviers.data.source.TvShowRepository
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowEntityResponse

class DetailTvShowViewModel(private val tvShowRepository: TvShowRepository): ViewModel() {
    private lateinit var tvShowId: String

    fun setCurrentTvShow(tvShowId: String){
        this.tvShowId = tvShowId
    }

    fun getDetailTvShow() : LiveData<TvShowEntityResponse> = tvShowRepository.getDetailTvShow(tvShowId)

    fun getLoadingStatus(): LiveData<Boolean> = tvShowRepository.isLoading
}