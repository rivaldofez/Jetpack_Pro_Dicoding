package com.rivaldofez.moviers.ui.detail.tvshow

import androidx.lifecycle.ViewModel
import com.rivaldofez.moviers.entity.TvShowEntity
import com.rivaldofez.moviers.utils.DataDummy

class DetailTvShowViewModel: ViewModel() {
    private lateinit var tvShowId: String

    fun setCurrentTvShow(tvShowId: String){
        this.tvShowId = tvShowId
    }

    fun getTvShow(): TvShowEntity {
        lateinit var tvShow: TvShowEntity
        val tvShows = DataDummy.generateDummyTvShow()

        for(iTvShow in tvShows){
            if (tvShowId == iTvShow.id){
                tvShow = iTvShow
                break
            }
        }
        return tvShow
    }
}