package com.rivaldofez.moviers.ui.movie

import android.view.View
import com.rivaldofez.moviers.entity.MovieEntity

interface MovieFragmentCallback {
    fun onMovieClick(movie: MovieEntity)
}