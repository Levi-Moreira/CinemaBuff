package com.levimoreira.cinemabuff.movie.data

import com.cinemabuff.data.models.TopMovieListResponse
import com.cinemabuff.data.network.TmdbApi
import io.reactivex.Single

class MovieRepositoryImpl(val tmdbService: TmdbApi) :
        MovieRepository {

    override fun getMovies(page: Int): Single<TopMovieListResponse> {
        return tmdbService.getTopMovies(page = page)
    }
}