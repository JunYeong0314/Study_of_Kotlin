package com.example.umc_prepare


import com.squareup.moshi.Json

data class Server(
    @Json(name = "description")
    val description: String?,
    @Json(name = "url")
    val url: String?
)