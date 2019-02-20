package com.levimoreira.cinemabuff.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.levimoreira.cinemabuff.BuildConfig
import com.levimoreira.cinemabuff.data.models.Movie

@Database(
    entities = [
        Movie::class],
    version = BuildConfig.DATABASE_VERSION
)
abstract class TmdbDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}