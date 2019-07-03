package com.levimoreira.cinemabuff.movie.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.levimoreira.cinemabuff.domain.entities.Movie

class MovieViewModel(dataSourceFactory: MovieDataSourceFactory) : ViewModel() {

    private val config = PagedList.Config.Builder()
            .setPageSize(20)
            .build()

    val movieDataSource: MovieDataSource = dataSourceFactory.create() as MovieDataSource

    private val pagedList = LivePagedListBuilder(dataSourceFactory, config)
            .setInitialLoadKey(1)
            .build()

    fun getMovies(): LiveData<PagedList<Movie>> {
        return pagedList
    }

    fun invalidateDataSource() {
        movieDataSource.invalidate()
    }
}