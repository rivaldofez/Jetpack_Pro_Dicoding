package com.rivaldofez.moviers.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowEntity (
        var id: Int,
        var title: String,
        var overview: String,
        var date: String,
        var status: String,
        var rating: Int,
        var episode: Int,
        var studio: String,
        var posterPath : String
): Parcelable