package com.romerojhh.notetaker

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NoteTakerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize any dependencies or libraries here
    }
}
