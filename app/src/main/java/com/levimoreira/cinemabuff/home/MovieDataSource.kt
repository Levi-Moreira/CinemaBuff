package com.levimoreira.cinemabuff.home

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.levimoreira.cinemabuff.domain.entities.Movie
import com.levimoreira.cinemabuff.domain.entities.NetworkState
import com.levimoreira.cinemabuff.domain.movie.MovieRepository
import kotlinx.coroutines.*

class MovieDataSource(
        private val repository: MovieRepository
) : PageKeyedDataSource<Int, Movie>() {
    var loadState: MutableLiveData<NetworkState> = MutableLiveData()

    private var scope = CoroutineScope(
            Job() + Dispatchers.Default
    )

    override fun loadInitial(
            params: LoadInitialParams<Int>,
            callback: LoadInitialCallback<Int, Movie>
    ) {
        loadState.postValue(NetworkState.LOADING)

        scope.launch {
            val result = repository.getMovies(page = 1)
            if (result == null) {
                loadState.postValue(NetworkState.error("Error getting network data"))
            } else {
                callback.onResult(result, null, 2)
                loadState.postValue(NetworkState.LOADED)
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        loadState.postValue(NetworkState.LOADING)

        scope.launch {
            val result = repository.getMovies(page = params.key)
            if (result == null) {
                loadState.postValue(NetworkState.error("Error getting network data"))
            } else {
                callback.onResult(result, params.key + 1)
                loadState.postValue(NetworkState.LOADED)
            }

        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        loadState.postValue(NetworkState.LOADED)
    }

    @ExperimentalCoroutinesApi
    override fun invalidate() {
        super.invalidate()
        scope.cancel()
    }
}