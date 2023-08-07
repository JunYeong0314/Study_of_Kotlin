package com.example.umc_prepare


import com.squareup.moshi.Json

data class First(
    @Json(name = "enum")
    val `enum`: List<String?>?,
    @Json(name = "type")
    val type: String?
)