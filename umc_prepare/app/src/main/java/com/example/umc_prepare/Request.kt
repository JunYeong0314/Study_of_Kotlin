package com.example.umc_prepare


import com.squareup.moshi.Json

data class Request(
    @Json(name = "$ref")
    val ref: String?
)