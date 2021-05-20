package com.rivaldofez.moviers.ui.home.tvshow

import com.rivaldofez.moviers.entity.TvShowEntity

interface TvShowFragmentCallback {
    fun onTvShowClick(tvShow: TvShowEntity)
}