package com.levimoreira.cinemabuff.movie.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.levimoreira.cinemabuff.domain.entities.Movie
import com.levimoreira.cinemabuff.domain.entities.NetworkState
import com.levimoreira.cinemabuff.domain.movie.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MovieDataSource(private val repository: MovieRepository) : PageKeyedDataSource<Int, Movie>() {

    private val disposableBag = CompositeDisposable()
    var loadState: MutableLiveData<NetworkState> = MutableLiveData()

    override fun loadInitial(
            params: LoadInitialParams<Int>,
            callback: LoadInitialCallback<Int, Movie>
    ) {
        loadState.postValue(NetworkState.LOADING)
        val disposable = repository.getMovies(page = 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it, null, 2)
                    loadState.postValue(NetworkState.LOADED)
                }, {
                    Timber.e(it)
                    loadState.postValue(NetworkState.error(it.message))
                })

        disposableBag.add(disposable)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        loadState.postValue(NetworkState.LOADING)
        val disposable = repository.getMovies(page = params.key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it, params.key + 1)
                    loadState.postValue(NetworkState.LOADED)
                }, {
                    Timber.e(it)
                    loadState.postValue(NetworkState.error(it.message))
                })
        disposableBag.add(disposable)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        loadState.postValue(NetworkState.LOADED)
    }

    override fun invalidate() {
        super.invalidate()
        disposableBag.dispose()
    }
}