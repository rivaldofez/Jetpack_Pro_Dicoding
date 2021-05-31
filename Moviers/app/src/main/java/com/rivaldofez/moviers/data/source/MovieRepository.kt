package com.rivaldofez.moviers.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rivaldofez.moviers.data.source.remote.response.RemoteDataSource
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieEntityResponse
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieItem

class MovieRepository(private val remoteDataSource: RemoteDataSource): MovieDataSource {

    companion object{
        @Volatile
        private var instance: MovieRepository? = null
        fun getInstance(remoteDataSource: RemoteDataSource): MovieRepository =
                instance ?: synchronized(this){
                    instance ?: MovieRepository(remoteDataSource).apply { instance = this }
                }
    }

    override fun getPopularMovies(): LiveData<List<MovieItem>> {
        val movieResults = MutableLiveData<List<MovieItem>>()
        remoteDataSource.getPopularMovies(object : RemoteDataSource.LoadPopularMoviesCallback{
            override fun onPopularMoviesLoaded(moviesResponses: List<MovieItem>) {
                movieResults.postValue(moviesResponses)
            }
        })
        return movieResults
    }

    override fun getDetailMovie(movieId: String): LiveData<MovieEntityResponse> {
        val detailMovieResult = MutableLiveData<MovieEntityResponse>()
        remoteDataSource.getDetailMovie(object : RemoteDataSource.LoadDetailMovieCallback{
            override fun onMovieLoaded(movieEntityResponse: MovieEntityResponse) {
                detailMovieResult.postValue(movieEntityResponse)
            }
        }, movieId)

        return detailMovieResult
    }
}