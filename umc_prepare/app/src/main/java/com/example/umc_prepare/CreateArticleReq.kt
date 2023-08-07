package com.example.umc_prepare


import com.squareup.moshi.Json

data class CreateArticleReq(
    @Json(name = "properties")
    val properties: PropertiesXXX?,
    @Json(name = "type")
    val type: String?
)