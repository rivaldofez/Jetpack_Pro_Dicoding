package com.rivaldofez.moviers.ui.home.movie

import androidx.lifecycle.ViewModel
import com.rivaldofez.moviers.data.source.local.entity.MovieEntity
import com.rivaldofez.moviers.utils.DataDummy

class MovieViewModel: ViewModel() {
    fun getMovies() : List<MovieEntity> = DataDummy.generateDummyMovies()
}