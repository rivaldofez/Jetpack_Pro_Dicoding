package com.rivaldofez.moviers.ui.home.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rivaldofez.moviers.data.source.MovieRepository
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieItem

class MovieViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getPopularMovies(): LiveData<List<MovieItem>> = movieRepository.getPopularMovies()

    fun getLoadingStatus(): LiveData<Boolean> = movieRepository.isLoading
}