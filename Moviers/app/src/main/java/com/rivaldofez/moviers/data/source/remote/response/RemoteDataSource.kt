package com.rivaldofez.moviers.data.source.remote.response

import android.util.Log
import com.rivaldofez.moviers.BuildConfig
import com.rivaldofez.moviers.data.source.remote.config.ApiConfig
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieEntityResponse
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieItem
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieListResponse
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowEntityResponse
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowItem
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource()
            }
    }

    fun getPopularMovies(callback: LoadPopularMoviesCallback){
        val client = ApiConfig.getApiService().getPopularMovies(key = BuildConfig.API_KEY, page = "1")
        client.enqueue(object: Callback<MovieListResponse>{
            override fun onResponse(
                call: Call<MovieListResponse>,
                response: Response<MovieListResponse>
            ) {
                response.body()?.results?.let { callback.onPopularMoviesLoaded(it) }
            }

            override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "fail at getPopularMovies because: ${t.message}")
            }
        })
    }

    fun getPopularTvShow(callback: LoadPopularTvShowCallback){
        val client = ApiConfig.getApiService().getPopularTvShow(key = BuildConfig.API_KEY, page = "1")
        client.enqueue(object: Callback<TvShowListResponse>{
            override fun onResponse(
                call: Call<TvShowListResponse>,
                response: Response<TvShowListResponse>
            ) {
                response.body()?.results?.let { callback.onPopularTvShowsLoaded(it) }
            }

            override fun onFailure(call: Call<TvShowListResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "fail at getPopularTvShows because: ${t.message}")
            }
        })
    }

    fun getDetailMovie(callback: LoadDetailMovieCallback, movieId: String){
        val client = ApiConfig.getApiService().getMovieById(key = BuildConfig.API_KEY,id =  movieId)
        client.enqueue(object: Callback<MovieEntityResponse>{
            override fun onResponse(
                call: Call<MovieEntityResponse>,
                response: Response<MovieEntityResponse>
            ) {
                response.body()?.let { callback.onMovieLoaded(it) }
            }

            override fun onFailure(call: Call<MovieEntityResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "fail at getDetailMovie because: ${t.message}")
            }
        })
    }

    fun getDetailTvShow(callback: LoadDetailTvShowCallback, tvShowId: String){
        val client = ApiConfig.getApiService().getTvShowById(key = BuildConfig.API_KEY, id = tvShowId)
        client.enqueue(object: Callback<TvShowEntityResponse>{
            override fun onResponse(
                call: Call<TvShowEntityResponse>,
                response: Response<TvShowEntityResponse>
            ) {
                response.body()?.let { callback.onTvShowLoaded(it) }
            }

            override fun onFailure(call: Call<TvShowEntityResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "fail at getDetailTvShow because: ${t.message}")
            }
        })
    }

    interface  LoadPopularMoviesCallback{
        fun onPopularMoviesLoaded(moviesResponses: List<MovieItem>)
    }

    interface LoadPopularTvShowCallback{
        fun onPopularTvShowsLoaded(tvshowResponse: List<TvShowItem>)
    }

    interface LoadDetailMovieCallback{
        fun onMovieLoaded(movieEntityResponse: MovieEntityResponse)
    }

    interface LoadDetailTvShowCallback{
        fun onTvShowLoaded(tvShowEntityResponse: TvShowEntityResponse)
    }
}