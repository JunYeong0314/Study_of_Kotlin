package com.example.umc_prepare


import com.squareup.moshi.Json

data class JwtAuth(
    @Json(name = "bearerFormat")
    val bearerFormat: String?,
    @Json(name = "scheme")
    val scheme: String?,
    @Json(name = "type")
    val type: String?
)