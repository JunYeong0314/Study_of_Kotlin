package com.example.temp

import okhttp3.internal.platform.Android10Platform

// 플랫폼 매니저 (카카오 or 네이버 구분기능)
object PlatformManager {
    private var platform: String = ""

    fun setPlatform(platform: String){
        this.platform = platform
    }

    fun getPlatform(): String{
        return platform
    }
}