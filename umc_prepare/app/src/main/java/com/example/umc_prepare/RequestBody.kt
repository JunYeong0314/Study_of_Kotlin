package com.example.umc_prepare


import com.squareup.moshi.Json

data class RequestBody(
    @Json(name = "content")
    val content: ContentXXXX?,
    @Json(name = "required")
    val required: Boolean?
)