package com.rivaldofez.moviers.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rivaldofez.moviers.data.source.MovieDataSource
import com.rivaldofez.moviers.data.source.remote.response.RemoteDataSource
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieEntityResponse
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieItem

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource): MovieDataSource {

    val isLoading = MutableLiveData<Boolean>()

    override fun getPopularMovies(): LiveData<List<MovieItem>> {
        isLoading.value = true
        val movieResults = MutableLiveData<List<MovieItem>>()
        remoteDataSource.getPopularMovies(object : RemoteDataSource.LoadPopularMoviesCallback{
            override fun onPopularMoviesLoaded(moviesResponses: List<MovieItem>) {
                isLoading.value = false
                movieResults.postValue(moviesResponses)
            }
        })
        return movieResults
    }

    override fun getDetailMovie(movieId: String): LiveData<MovieEntityResponse> {
        isLoading.value = true
        val detailMovieResult = MutableLiveData<MovieEntityResponse>()
        remoteDataSource.getDetailMovie(object : RemoteDataSource.LoadDetailMovieCallback{
            override fun onMovieLoaded(movieEntityResponse: MovieEntityResponse) {
                isLoading.value = false
                detailMovieResult.postValue(movieEntityResponse)
            }
        }, movieId)

        return detailMovieResult
    }
}