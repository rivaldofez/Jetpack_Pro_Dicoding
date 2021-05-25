package com.rivaldofez.moviers.data.source

import com.rivaldofez.moviers.data.source.local.entity.MovieEntity
import com.rivaldofez.moviers.data.source.local.entity.TvShowEntity

interface ContentDataSource {
    fun getAllMovies(): List<MovieEntity>

    fun getAllTvShows(): List<TvShowEntity>

    fun getMovieById(movieId: String) : MovieEntity

    fun getTvShowById(tvShowId: String) :TvShowEntity
}