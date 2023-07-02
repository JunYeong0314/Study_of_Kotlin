package com.example.umc_prepare

import android.app.Application
import android.content.Intent
import android.util.Log

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e("App class", "onCreate")
        val sharedPreferenceManager = SharedPreferenceManager.getInstance(this)
        val token = sharedPreferenceManager.getToken()

        val intent = if (token.isNotEmpty()) {
            Intent(this, FirstActivity::class.java)
        } else {
            Intent(this, MainActivity::class.java)
        }
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

}