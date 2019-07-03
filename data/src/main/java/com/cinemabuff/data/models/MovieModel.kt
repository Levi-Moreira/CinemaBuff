package com.cinemabuff.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cinemabuff.data.BuildConfig
import com.cinemabuff.data.models.MovieModel.Companion.TABLE_NAME
import com.google.gson.annotations.SerializedName
import com.levimoreira.cinemabuff.domain.entities.Movie

@Entity(tableName = TABLE_NAME)
data class MovieModel(

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


    fun toDomain(): Movie {
        return Movie(
                id,
                video,
                popularity,
                overview,
                title,
                getCompletePosterPath(),
                voteCount,
                voteAvg,
                releaseDate
        )
    }

    fun getCompletePosterPath() = BuildConfig.IMAGES_SERVER_BASE_URL + posterPath

    companion object {
        const val TABLE_NAME = "movie"


    }
}