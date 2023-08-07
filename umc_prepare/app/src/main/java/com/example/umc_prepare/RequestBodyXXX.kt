package com.example.umc_prepare


import com.squareup.moshi.Json

data class RequestBodyXXX(
    @Json(name = "content")
    val content: ContentXXXXXXXXXXXXXXXXXXXXXXXXXXX?,
    @Json(name = "required")
    val required: Boolean?
)