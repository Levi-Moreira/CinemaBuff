package com.levimoreira.cinemabuff.movie

import androidx.recyclerview.widget.DiffUtil
import com.levimoreira.cinemabuff.infrastructure.data.models.Movie

class MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem == newItem
}