package com.cinemabuff.data.models

import com.google.gson.annotations.SerializedName

class MovieListResponse(
        val page: Int,
        @SerializedName("total_results") val totalResults: Int,
        @SerializedName("total_pages") val totalPages: Int,
        val results: List<MovieModel>
)