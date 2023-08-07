package com.example.umc_prepare


import com.squareup.moshi.Json

data class Responses(
    @Json(name = "200")
    val x200: X200?,
    @Json(name = "404")
    val x404: X200?
)