package com.levimoreira.cinemabuff.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.levimoreira.cinemabuff.R
import com.levimoreira.cinemabuff.domain.entities.Movie
import com.levimoreira.cinemabuff.domain.entities.NetworkState
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
class HomeFragment : Fragment() {

    private val movieViewModel: MovieViewModel by viewModel()

    lateinit var moviesAdapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpMovieList()
    }

    private fun setUpMovieList() {
        moviesAdapter = MovieListAdapter()
        movieList.apply {
            adapter = moviesAdapter
            layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        moviesAdapter.onMovieClickListener = ::onMovieClick

        movieViewModel.movieDataSource.loadState.observe(this, Observer {
            swipeRefreshLayout.isRefreshing =
                it == NetworkState.LOADING
        })

        movieViewModel.getMovies().observe(this, Observer {
            moviesAdapter.submitList(it)
        })

        swipeRefreshLayout.setOnRefreshListener {
            movieViewModel.invalidateDataSource()
        }
    }

    private fun onMovieClick(movie: Movie) {
        Toast.makeText(context, movie.title, Toast.LENGTH_SHORT).show()
    }
}