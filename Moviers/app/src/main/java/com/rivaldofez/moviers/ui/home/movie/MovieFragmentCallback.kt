package com.rivaldofez.moviers.ui.home.movie

import com.rivaldofez.moviers.data.source.remote.response.movie.MovieItem

interface MovieFragmentCallback {
    fun onMovieClick(movie: MovieItem)
}