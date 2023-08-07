package com.example.umc_prepare


import com.squareup.moshi.Json

data class ArticlePhoto(
    @Json(name = "items")
    val items: ItemsX?,
    @Json(name = "type")
    val type: String?
)