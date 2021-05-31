package com.rivaldofez.moviers.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rivaldofez.moviers.data.source.MovieRepository
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieEntityResponse

class DetailMovieViewModel(private val movieRepository: MovieRepository) : ViewModel(){
    private lateinit var movieId: String

    fun setCurrentMovie(movieId: String){
        this.movieId = movieId
    }

    fun getDetailMovie(): LiveData<MovieEntityResponse> = movieRepository.getDetailMovie(movieId)
}