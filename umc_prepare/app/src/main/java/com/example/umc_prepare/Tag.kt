package com.example.umc_prepare


import com.squareup.moshi.Json

data class Tag(
    @Json(name = "description")
    val description: String?,
    @Json(name = "name")
    val name: String?
)