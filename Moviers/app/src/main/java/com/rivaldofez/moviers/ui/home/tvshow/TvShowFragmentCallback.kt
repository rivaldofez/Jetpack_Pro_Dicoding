package com.rivaldofez.moviers.ui.home.tvshow

import com.rivaldofez.moviers.data.source.local.entity.TvShowEntity

interface TvShowFragmentCallback {
    fun onTvShowClick(tvShow: TvShowEntity)
}