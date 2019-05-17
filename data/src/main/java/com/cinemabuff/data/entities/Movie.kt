package com.cinemabuff.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cinemabuff.data.BuildConfig
import com.cinemabuff.data.entities.Movie.Companion.TABLE_NAME
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_NAME)
data class Movie(

        @PrimaryKey
        val id: Long,
        val video: Boolean,
        val popularity: Float,
        val overview: String,
        val title: String,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("vote_count") val voteCount: Int,
        @SerializedName("vote_average") val voteAvg: Float,
        @SerializedName("release_date") val releaseDate: String
) {

    fun getCompletePosterPath() = BuildConfig.IMAGES_SERVER_BASE_URL + posterPath

    companion object {
        const val TABLE_NAME = "movie"
    }
}