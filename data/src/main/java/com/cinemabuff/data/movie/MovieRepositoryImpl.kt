package com.cinemabuff.data.movie

import com.cinemabuff.data.BaseRepository
import com.cinemabuff.data.network.TmdbApi
import com.levimoreira.cinemabuff.domain.entities.Movie
import com.levimoreira.cinemabuff.domain.movie.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(val tmdbService: TmdbApi) : BaseRepository(),
    MovieRepository {

    override suspend fun getMovies(page: Int): List<Movie>? {
        return call(
            { tmdbService.getTopMovies(page = page).results.map { it.toDomain() } },
            "Error Getting Movies"
        )
    }
}