package com.levimoreira.cinemabuff.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.levimoreira.cinemabuff.domain.entities.Movie
import kotlinx.coroutines.ExperimentalCoroutinesApi

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

    @ExperimentalCoroutinesApi
    fun invalidateDataSource() {
        movieDataSource.invalidate()
    }
}