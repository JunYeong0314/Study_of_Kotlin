package com.example.umc_prepare


import com.squareup.moshi.Json

data class ArticlePhotoX(
    @Json(name = "items")
    val items: ItemsXXXXX?,
    @Json(name = "type")
    val type: String?
)