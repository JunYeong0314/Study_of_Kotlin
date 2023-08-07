package com.example.umc_prepare


import com.squareup.moshi.Json

data class Greeting(
    @Json(name = "description")
    val description: String?,
    @Json(name = "example")
    val example: String?,
    @Json(name = "type")
    val type: String?
)