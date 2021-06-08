package com.rivaldofez.academy.di

import android.content.Context
import com.rivaldofez.academy.data.AcademyRepository
import com.rivaldofez.academy.data.source.local.LocalDataSource
import com.rivaldofez.academy.data.source.local.room.AcademyDatabase
import com.rivaldofez.academy.data.source.remote.RemoteDataSource
import com.rivaldofez.academy.utils.AppExecutors
import com.rivaldofez.academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val database = AcademyDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}
