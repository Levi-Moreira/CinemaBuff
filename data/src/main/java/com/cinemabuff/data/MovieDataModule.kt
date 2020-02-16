package com.cinemabuff.data

import com.cinemabuff.data.movie.MovieRepositoryImpl
import com.cinemabuff.data.network.TmdbApi
import com.levimoreira.cinemabuff.domain.movie.MovieRepository
import org.koin.dsl.module.module

val movieDataModule = module {
    single<MovieRepository> { provideMovieRepository(get()) }
}

fun provideMovieRepository(tmdbApi: TmdbApi) =
    MovieRepositoryImpl(tmdbApi)
