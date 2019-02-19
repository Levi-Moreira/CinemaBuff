package com.levimoreira.cinemabuff.data.retrofit

import com.google.gson.annotations.SerializedName
import com.levimoreira.cinemabuff.data.models.Movie

class TopMovieListResponse(
    val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    val result: List<Movie>
)