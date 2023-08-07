package com.example.umc_prepare


import com.squareup.moshi.Json

data class Items(
    @Json(name = "$ref")
    val ref: String?
)