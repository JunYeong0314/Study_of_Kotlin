package com.example.umc_prepare


import com.squareup.moshi.Json

data class Info(
    @Json(name = "description")
    val description: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "version")
    val version: String?
)