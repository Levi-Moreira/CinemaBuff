package com.cinemabuff.data.models

import com.cinemabuff.data.entities.Movie
import com.google.gson.annotations.SerializedName

class TopMovieListResponse(
        val page: Int,
        @SerializedName("total_results") val totalResults: Int,
        @SerializedName("total_pages") val totalPages: Int,
        val results: List<Movie>
)