package com.example.umc_prepare


import com.squareup.moshi.Json

data class ResponsesX(
    @Json(name = "200")
    val x200: X200?,
    @Json(name = "400")
    val x400: X200?,
    @Json(name = "404")
    val x404: X200?
)