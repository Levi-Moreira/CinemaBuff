package com.cinemabuff.data.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dataObject: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg dataObject: T)

    @Update
    fun update(dataObject: T): Int

    @Delete
    fun delete(dataObject: T): Int
}