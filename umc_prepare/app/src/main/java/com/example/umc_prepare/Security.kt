package com.example.umc_prepare


import com.squareup.moshi.Json

data class Security(
    @Json(name = "jwtAuth")
    val jwtAuth: List<Any?>?
)