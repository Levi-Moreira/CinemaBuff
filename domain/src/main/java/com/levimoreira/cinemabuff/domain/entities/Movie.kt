package com.levimoreira.cinemabuff.domain.entities


data class Movie(
    val id: Long,
    val video: Boolean,
    val popularity: Float,
    val overview: String,
    val title: String,
    val posterPath: String,
    val voteCount: Int,
    val voteAvg: Float,
    val releaseDate: String
)