package com.levimoreira.cinemabuff.movie.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.levimoreira.cinemabuff.R
import com.levimoreira.cinemabuff.domain.entities.Movie
import com.levimoreira.cinemabuff.domain.entities.NetworkState
import com.levimoreira.cinemabuff.movie.viewmodels.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val movieViewModel: MovieViewModel by viewModel()

    lateinit var moviesAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpMovieList()
    }

    private fun setUpMovieList() {
        moviesAdapter = MovieListAdapter()
        movieList.apply {
            adapter = moviesAdapter
            layoutManager =
                    LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }

        movieList.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))

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
        Toast.makeText(this, movie.title, Toast.LENGTH_SHORT).show()
    }
}
