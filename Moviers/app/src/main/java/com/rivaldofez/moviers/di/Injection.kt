package com.rivaldofez.moviers.di

import com.rivaldofez.moviers.data.source.MovieRepository
import com.rivaldofez.moviers.data.source.TvShowRepository
import com.rivaldofez.moviers.data.source.remote.response.RemoteDataSource

object Injection {
    fun provideMovieRepository(): MovieRepository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return MovieRepository.getInstance(remoteDataSource)
    }

    fun provideTvShowRepository(): TvShowRepository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return TvShowRepository.getInstance(remoteDataSource)
    }
}