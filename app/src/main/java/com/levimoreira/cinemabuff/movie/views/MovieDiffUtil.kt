package com.levimoreira.cinemabuff.movie.views

import androidx.recyclerview.widget.DiffUtil
import com.levimoreira.cinemabuff.domain.entities.Movie


class MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.title == newItem.title && oldItem.overview == newItem.overview
    }
}