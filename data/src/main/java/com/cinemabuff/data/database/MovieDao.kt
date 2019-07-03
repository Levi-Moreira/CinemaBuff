package com.cinemabuff.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.cinemabuff.data.models.MovieModel

@Dao
interface MovieDao : BaseDao<MovieModel> {
    @Query("SELECT * from ${MovieModel.TABLE_NAME}")
    fun getAll(): LiveData<List<MovieModel>>

    @Query("DELETE FROM ${MovieModel.TABLE_NAME}")
    fun clearTable(): Int
}