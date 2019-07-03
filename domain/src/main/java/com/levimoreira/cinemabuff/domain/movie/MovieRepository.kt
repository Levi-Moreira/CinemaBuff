package com.levimoreira.cinemabuff.domain.movie

import com.levimoreira.cinemabuff.domain.entities.Movie
import io.reactivex.Single

interface MovieRepository {
    fun getMovies(page: Int): Single<List<Movie>>
}