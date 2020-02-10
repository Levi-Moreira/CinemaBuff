package com.levimoreira.cinemabuff.home

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.levimoreira.cinemabuff.R
import com.levimoreira.cinemabuff.domain.entities.Movie
import com.levimoreira.cinemabuff.utils.inflate
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MovieListAdapter :
    PagedListAdapter<Movie, MovieListAdapter.MovieViewHolder>(
        MovieDiffUtil()
    ) {

    lateinit var onMovieClickListener: (Movie) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(parent.inflate(R.layout.movie_list_item))

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it, onMovieClickListener)
        }
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Movie, onMovieClickListener: (Movie) -> Unit) = with(itemView) {
            Glide.with(itemView).load(item.posterPath).into(moviePoster)
            movieTitle.text = item.title
            movieDescription.text = item.overview
            itemView.setOnClickListener {
                onMovieClickListener(item)
            }
        }
    }
}