package com.cinemabuff.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cinemabuff.data.BuildConfig
import com.cinemabuff.data.models.MovieModel

@Database(
    entities = [
        MovieModel::class],
    version = BuildConfig.DATABASE_VERSION
)
abstract class TmdbDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}