package com.example.umc_prepare


import com.squareup.moshi.Json

data class Pageable(
    @Json(name = "$ref")
    val ref: String?
)