package com.levimoreira.cinemabuff.infrastructure.application

import android.app.Application
import com.levimoreira.cinemabuff.infrastructure.api.networkModule
import org.koin.android.ext.android.startKoin

class CinemaBuffApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule, networkModule))
    }
}