package com.example.umc_prepare


import com.squareup.moshi.Json

data class ArticleId(
    @Json(name = "description")
    val description: String?,
    @Json(name = "format")
    val format: String?,
    @Json(name = "type")
    val type: String?
)