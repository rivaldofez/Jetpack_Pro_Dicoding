package com.rivaldofez.moviers.data.source

import androidx.lifecycle.LiveData
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieEntityResponse
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieItem

interface MovieDataSource {
    fun getPopularMovies(): LiveData<List<MovieItem>>

    fun getDetailMovie(movieId: String): LiveData<MovieEntityResponse>
}