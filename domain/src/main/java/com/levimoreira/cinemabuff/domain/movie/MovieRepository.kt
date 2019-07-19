package com.levimoreira.cinemabuff.domain.movie

import com.levimoreira.cinemabuff.domain.entities.Movie

interface MovieRepository {
    suspend fun getMovies(page: Int): List<Movie>?
}