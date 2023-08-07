package com.example.umc_prepare


import com.squareup.moshi.Json

data class SortX(
    @Json(name = "items")
    val items: ItemsXXXX?,
    @Json(name = "type")
    val type: String?
)