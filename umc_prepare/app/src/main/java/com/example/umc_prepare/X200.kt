package com.example.umc_prepare


import com.squareup.moshi.Json

data class X200(
    @Json(name = "content")
    val content: ContentXXXX?,
    @Json(name = "description")
    val description: String?
)