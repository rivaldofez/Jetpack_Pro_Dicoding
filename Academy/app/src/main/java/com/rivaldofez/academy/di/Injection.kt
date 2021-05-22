package com.rivaldofez.academy.di

import android.content.Context
import com.rivaldofez.academy.data.source.AcademyRepository
import com.rivaldofez.academy.data.source.remote.RemoteDataSource
import com.rivaldofez.academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return AcademyRepository.getInstance(remoteDataSource)
    }
}