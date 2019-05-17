package com.levimoreira.cinemabuff.movie.data

import com.cinemabuff.data.models.TopMovieListResponse
import io.reactivex.Single

interface MovieRepository {
    fun getMovies(page: Int): Single<TopMovieListResponse>
}