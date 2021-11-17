package br.com.alura.ceep.ui.challenge_movielist.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var id: Long,
    var title: String,
    var year: Long,
    var runtime: Long,
    var director: String,
    var actors: String,
    var plot: String,
    var posterUrl: String
):Parcelable