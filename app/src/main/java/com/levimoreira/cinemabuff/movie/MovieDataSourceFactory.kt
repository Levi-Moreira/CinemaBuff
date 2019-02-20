package com.levimoreira.cinemabuff.movie

import androidx.paging.DataSource
import com.levimoreira.cinemabuff.infrastructure.data.models.Movie

class MovieDataSourceFactory(val movieRepository: MovieRepository) :
    DataSource.Factory<Int, Movie>() {
    override fun create(): DataSource<Int, Movie> = MovieDataSource(movieRepository)
}