package com.levimoreira.cinemabuff.infrastructure.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.levimoreira.cinemabuff.BuildConfig
import com.levimoreira.cinemabuff.infrastructure.data.models.Movie.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Movie(

    @PrimaryKey
    val id: Long,
    val video: Boolean,
    val popularity: Int,
    val overview: String,
    val title: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("vote_average") val voteAvg: Float,
    @SerializedName("release_date") val releaseDate: String
) {

    fun getCompletePosterPath() = BuildConfig.SERVER_BASE_URL + posterPath

    companion object {
        const val TABLE_NAME = "movie"
    }
}