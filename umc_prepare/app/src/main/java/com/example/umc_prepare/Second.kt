package com.example.umc_prepare


import com.squareup.moshi.Json

data class Second(
    @Json(name = "enum")
    val `enum`: List<String?>?,
    @Json(name = "type")
    val type: String?
)