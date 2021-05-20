package com.rivaldofez.moviers.ui.home.tvshow

import androidx.lifecycle.ViewModel
import com.rivaldofez.moviers.entity.TvShowEntity
import com.rivaldofez.moviers.utils.DataDummy

class TvShowViewModel: ViewModel() {
    fun getTvShows() : List<TvShowEntity> = DataDummy.generateDummyTvShow()
}