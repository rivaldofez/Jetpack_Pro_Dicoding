package com.rivaldofez.moviers.ui.home.movie

import com.rivaldofez.moviers.entity.MovieEntity

interface MovieFragmentCallback {
    fun onMovieClick(movie: MovieEntity)
}