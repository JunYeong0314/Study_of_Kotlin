package com.example.umc_prepare


import com.squareup.moshi.Json

data class ContentXX(
    @Json(name = "items")
    val items: ItemsXXX?,
    @Json(name = "type")
    val type: String?
)