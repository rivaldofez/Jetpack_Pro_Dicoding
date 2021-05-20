package com.rivaldofez.moviers.ui.home.movie

import androidx.lifecycle.ViewModel
import com.rivaldofez.moviers.entity.MovieEntity
import com.rivaldofez.moviers.utils.DataDummy

class MovieViewModel: ViewModel() {
    fun getMovies() : List<MovieEntity> = DataDummy.generateDummyMovies()
}