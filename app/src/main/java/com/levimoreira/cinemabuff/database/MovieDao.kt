package com.levimoreira.cinemabuff.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.levimoreira.cinemabuff.data.models.Movie

@Dao
interface MovieDao : BaseDao<Movie> {
    @Query("SELECT * from ${Movie.TABLE_NAME}")
    fun getAll(): LiveData<List<Movie>>

    @Query("DELETE FROM ${Movie.TABLE_NAME}")
    fun clearTable(): Int
}