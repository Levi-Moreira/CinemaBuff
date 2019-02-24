package com.levimoreira.cinemabuff.movie.data

import com.levimoreira.cinemabuff.infrastructure.data.retrofit.TopMovieListResponse
import io.reactivex.Single

interface MovieRepository {
    fun getMovies(page: Int): Single<TopMovieListResponse>
}