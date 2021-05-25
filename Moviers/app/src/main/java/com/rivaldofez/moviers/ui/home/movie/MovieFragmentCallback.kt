package com.rivaldofez.moviers.ui.home.movie

import com.rivaldofez.moviers.data.source.local.entity.MovieEntity

interface MovieFragmentCallback {
    fun onMovieClick(movie: MovieEntity)
}