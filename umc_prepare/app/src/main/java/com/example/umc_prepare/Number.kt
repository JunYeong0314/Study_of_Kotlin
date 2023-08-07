package com.example.umc_prepare


import com.squareup.moshi.Json

data class Number(
    @Json(name = "format")
    val format: String?,
    @Json(name = "type")
    val type: String?
)