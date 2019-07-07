package com.levimoreira.cinemabuff.infrastructure

import com.levimoreira.cinemabuff.domain.movie.MovieRepository
import com.levimoreira.cinemabuff.home.MovieDataSourceFactory
import com.levimoreira.cinemabuff.home.MovieViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val movieModule = module {
    single<MovieDataSourceFactory> { provideMovieDataSourceFactory(get()) }
    viewModel { provideMovieViewModel(get()) }
}


fun provideMovieDataSourceFactory(repository: MovieRepository) =
        MovieDataSourceFactory(repository)

fun provideMovieViewModel(dataSourceFactory: MovieDataSourceFactory) =
        MovieViewModel(dataSourceFactory)