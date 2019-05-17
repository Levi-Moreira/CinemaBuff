package com.levimoreira.cinemabuff.movie

import com.cinemabuff.data.network.TmdbApi
import com.levimoreira.cinemabuff.movie.data.MovieDataSourceFactory
import com.levimoreira.cinemabuff.movie.data.MovieRepository
import com.levimoreira.cinemabuff.movie.data.MovieRepositoryImpl
import com.levimoreira.cinemabuff.movie.viewmodels.MovieViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val movieModule = module {
    single<MovieRepository> { provideMovieRepository(get()) }
    single<MovieDataSourceFactory> { provideMovieDataSourceFactory(get()) }
    viewModel { provideMovieViewModel(get()) }
}

fun provideMovieRepository(tmdbApi: TmdbApi) =
        MovieRepositoryImpl(tmdbApi)

fun provideMovieDataSourceFactory(repository: MovieRepository) =
        MovieDataSourceFactory(repository)

fun provideMovieViewModel(dataSourceFactory: MovieDataSourceFactory) =
        MovieViewModel(dataSourceFactory)