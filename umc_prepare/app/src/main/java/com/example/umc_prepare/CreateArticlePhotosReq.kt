package com.example.umc_prepare


import com.squareup.moshi.Json

data class CreateArticlePhotosReq(
    @Json(name = "properties")
    val properties: PropertiesXX?,
    @Json(name = "type")
    val type: String?
)