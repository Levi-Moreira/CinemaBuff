package com.levimoreira.cinemabuff.movie

import androidx.paging.PageKeyedDataSource
import com.levimoreira.cinemabuff.infrastructure.data.models.Movie

class MovieDataSource(val repository: MovieRepository) : PageKeyedDataSource<Int, Movie>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
    }
}