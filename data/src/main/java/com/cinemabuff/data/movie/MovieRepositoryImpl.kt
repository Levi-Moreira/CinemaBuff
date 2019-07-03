package com.cinemabuff.data.movie

import com.cinemabuff.data.models.MovieListResponse
import com.cinemabuff.data.network.TmdbApi
import com.levimoreira.cinemabuff.domain.entities.Movie
import com.levimoreira.cinemabuff.domain.movie.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(val tmdbService: TmdbApi) : MovieRepository {

    override fun getMovies(page: Int): Single<List<Movie>> {
        return tmdbService
                .getTopMovies(page = page)
                .flatMap { response: MovieListResponse ->
                    Single.just(response.results.map { it.toDomain() })
                }
    }
}