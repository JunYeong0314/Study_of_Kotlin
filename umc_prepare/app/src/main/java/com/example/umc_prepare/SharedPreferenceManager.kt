package com.example.umc_prepare

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager private constructor(context: Context) {
    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveToken(token: String) {
        sharedPreferences.edit().putString(KEY_TOKEN, token).apply()
    }

    fun getToken(): String {
        return sharedPreferences.getString(KEY_TOKEN, "") ?: ""
    }

    companion object {
        private const val PREF_NAME = "NaverLogin"
        private const val KEY_TOKEN = "token"

        @Volatile
        private var instance: SharedPreferenceManager? = null

        fun getInstance(context: Context): SharedPreferenceManager {
            return instance ?: synchronized(this) {
                instance ?: SharedPreferenceManager(context.applicationContext).also { instance = it }
            }
        }
    }
}