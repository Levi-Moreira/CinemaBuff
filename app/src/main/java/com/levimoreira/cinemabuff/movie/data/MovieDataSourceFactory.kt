package com.levimoreira.cinemabuff.movie.data

import androidx.paging.DataSource
import com.cinemabuff.data.entities.Movie

class MovieDataSourceFactory(private val movieRepository: MovieRepository) :
        DataSource.Factory<Int, Movie>() {
    override fun create(): DataSource<Int, Movie> {
        return MovieDataSource(movieRepository)
    }
}