package com.example.umc_prepare


import com.squareup.moshi.Json

data class ArticlePhotos(
    @Json(name = "items")
    val items: Items?,
    @Json(name = "type")
    val type: String?
)