package com.rivaldofez.moviers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rivaldofez.moviers.data.source.TvShowRepository
import com.rivaldofez.moviers.di.Injection
import com.rivaldofez.moviers.ui.detail.tvshow.DetailTvShowViewModel
import com.rivaldofez.moviers.ui.home.tvshow.TvShowViewModel

class ViewModelFactoryTvShow private constructor(private val tvShowRepository: TvShowRepository) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactoryTvShow? = null

        fun getInstance(): ViewModelFactoryTvShow =
                instance ?: synchronized(this){
                    instance ?: ViewModelFactoryTvShow(Injection.provideTvShowRepository()).apply {
                        instance = this
                    }
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(tvShowRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                DetailTvShowViewModel(tvShowRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}