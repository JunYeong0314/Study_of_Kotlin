package com.example.umc_prepare


import com.squareup.moshi.Json

data class Sorted(
    @Json(name = "type")
    val type: String?
)