package com.example.umc_prepare


import com.squareup.moshi.Json

data class Page(
    @Json(name = "format")
    val format: String?,
    @Json(name = "minimum")
    val minimum: Int?,
    @Json(name = "type")
    val type: String?
)