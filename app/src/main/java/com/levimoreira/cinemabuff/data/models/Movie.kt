package com.levimoreira.cinemabuff.data.models

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Long,
    val video: Boolean,
    val popularity: Int,
    val overview: String,
    val title: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("vote_average") val voteAvg: Float,
    @SerializedName("release_date") val releaseDate: String
)