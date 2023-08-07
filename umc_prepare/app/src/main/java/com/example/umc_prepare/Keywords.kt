package com.example.umc_prepare


import com.squareup.moshi.Json

data class Keywords(
    @Json(name = "items")
    val items: ItemsXX?,
    @Json(name = "type")
    val type: String?
)