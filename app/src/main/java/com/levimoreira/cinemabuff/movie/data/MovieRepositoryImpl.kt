package com.levimoreira.cinemabuff.movie.data

import com.levimoreira.cinemabuff.infrastructure.api.TmdbApi
import com.levimoreira.cinemabuff.infrastructure.data.retrofit.TopMovieListResponse
import io.reactivex.Single

class MovieRepositoryImpl(val tmdbService: TmdbApi) :
    MovieRepository {

    override fun getMovies(page: Int): Single<TopMovieListResponse> {
        return tmdbService.getTopMovies(page = page)
    }
}