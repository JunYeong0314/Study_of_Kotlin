package com.example.umc_prepare


import com.squareup.moshi.Json

data class Sort(
    @Json(name = "$ref")
    val ref: String?
)