package com.rivaldofez.moviers.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity(
    var id: String,
    var title: String,
    var overview: String,
    var date: String,
    var rating: Float,
    var studio: String,
    var posterPath: String,
    var backdropPath: String,
    var trailerUrl: String
):Parcelable