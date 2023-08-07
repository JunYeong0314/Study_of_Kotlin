package com.example.umc_prepare


import com.squareup.moshi.Json

data class NumberOfElements(
    @Json(name = "format")
    val format: String?,
    @Json(name = "type")
    val type: String?
)