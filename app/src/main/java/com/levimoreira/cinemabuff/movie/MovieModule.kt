package com.levimoreira.cinemabuff.movie

import com.levimoreira.cinemabuff.infrastructure.api.TmdbApi
import org.koin.dsl.module.module

val movieModule = module {
    single<MovieRepository> { provideMovieRepository(get()) }
}

fun provideMovieRepository(tmdbApi: TmdbApi) = MovieRepositoryImpl(tmdbApi)