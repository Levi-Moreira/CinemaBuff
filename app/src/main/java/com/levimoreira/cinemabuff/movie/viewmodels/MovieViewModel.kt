package com.levimoreira.cinemabuff.movie.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.levimoreira.cinemabuff.infrastructure.api.TmdbApi.Companion.TMDB_PAGE_SIZE
import com.levimoreira.cinemabuff.infrastructure.data.models.Movie
import com.levimoreira.cinemabuff.movie.data.MovieDataSource
import com.levimoreira.cinemabuff.movie.data.MovieDataSourceFactory

class MovieViewModel(dataSourceFactory: MovieDataSourceFactory) : ViewModel() {

    private val config = PagedList.Config.Builder()
        .setPageSize(TMDB_PAGE_SIZE)
        .build()

    val movieDataSource: MovieDataSource = dataSourceFactory.create() as MovieDataSource

    private val pagedList = LivePagedListBuilder(dataSourceFactory, config)
        .setInitialLoadKey(1)
        .build()

    fun getMovies(): LiveData<PagedList<Movie>>{
        return pagedList
    }

    fun invalidateDataSource() {
        movieDataSource.invalidate()
    }
}