package com.rivaldofez.moviers.data.source.remote.config

import com.rivaldofez.moviers.data.source.remote.response.movie.MovieEntityResponse
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieListResponse
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowEntityResponse
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowListResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("movie/popular?api_key={key}&page={page}")
    fun getPopularMovies(
        @Path("key") token: String,
        @Path("page") page: String
    ): Call<MovieListResponse>

    @GET("tv/popular?api_key={key}&page={page}")
    fun getPopularTvShow(
        @Path("key") token: String,
        @Path("page") page: String
    ): Call<TvShowListResponse>

    @GET("movie/{id}?api_key={key}")
    fun getMovieById(
        @Path("key") token: String,
        @Path("id") id: String
    ): Call<MovieEntityResponse>

    @GET("tv/{id}?api_key={key}")
    fun getTvShowById(
        @Path("key") token: String,
        @Path("id") id: String
    ): Call<TvShowEntityResponse>

}
