package com.example.umc_prepare


import com.squareup.moshi.Json

data class Birthdate(
    @Json(name = "type")
    val type: String?
)