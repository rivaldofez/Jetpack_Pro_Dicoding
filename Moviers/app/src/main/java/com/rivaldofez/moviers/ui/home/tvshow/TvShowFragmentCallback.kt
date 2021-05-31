package com.rivaldofez.moviers.ui.home.tvshow

import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowItem

interface TvShowFragmentCallback {
    fun onTvShowClick(tvShow: TvShowItem)
}