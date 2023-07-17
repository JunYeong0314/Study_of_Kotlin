package com.example.temp

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseActivity: Application() {
    override fun onCreate() {
        Log.d("BaseActivity", "onCreate")
        super.onCreate()
    }
}