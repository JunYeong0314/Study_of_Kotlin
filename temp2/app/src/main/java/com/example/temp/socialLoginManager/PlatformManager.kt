package com.example.temp.socialLoginManager

// 플랫폼 매니저 (카카오 or 네이버 구분기능)
object PlatformManager {
    private var platform: String = ""

    fun setPlatform(platform: String){
        PlatformManager.platform = platform
    }

    fun getPlatform(): String{
        return platform
    }
}