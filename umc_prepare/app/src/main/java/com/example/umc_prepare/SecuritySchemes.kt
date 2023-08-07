package com.example.umc_prepare


import com.squareup.moshi.Json

data class SecuritySchemes(
    @Json(name = "jwtAuth")
    val jwtAuth: JwtAuth?
)