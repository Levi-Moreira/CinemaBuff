package com.levimoreira.cinemabuff.home

import androidx.paging.DataSource
import com.levimoreira.cinemabuff.domain.entities.Movie
import com.levimoreira.cinemabuff.domain.movie.MovieRepository

class MovieDataSourceFactory(private val movieRepository: MovieRepository) :
        DataSource.Factory<Int, Movie>() {
    override fun create(): DataSource<Int, Movie> {
        return MovieDataSource(movieRepository)
    }
}