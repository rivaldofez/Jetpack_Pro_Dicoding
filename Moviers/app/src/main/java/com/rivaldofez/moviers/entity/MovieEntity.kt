package com.rivaldofez.moviers.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity (
    var id: Int,
    var title: String,
    var overview: String,
    var date: String,
    var rating: Int,
    var studio: String,
    var posterPath: String
):Parcelable